package com.versolicitud.movieapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versolicitud.movieapp.entity.RefreshToken;
import com.versolicitud.movieapp.entity.Role;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.exceptions.TokenRefreshException;
import com.versolicitud.movieapp.payload.request.LoginRequest;
import com.versolicitud.movieapp.payload.request.RegisterRequest;
import com.versolicitud.movieapp.payload.request.TokenRefreshRequest;
import com.versolicitud.movieapp.payload.response.JwtResponse;
import com.versolicitud.movieapp.payload.response.MessageResponse;
import com.versolicitud.movieapp.payload.response.TokenRefreshResponse;
import com.versolicitud.movieapp.security.jwt.JwtUtils;
import com.versolicitud.movieapp.security.services.UserDetailsImpl;
import com.versolicitud.movieapp.service.impl.RefreshTokenService;
import com.versolicitud.movieapp.service.impl.RoleService;
import com.versolicitud.movieapp.service.impl.UserService;
import com.versolicitud.movieapp.util.MailService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MailService mailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRe) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRe.getUsernameOrEmail(), loginRe.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerReq) {
        if (userService.checkExistedUsername(registerReq.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!", "error"));
        }

        if (userService.checkExistedEmail(registerReq.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!", "error"));
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByName("ROLE_USER"));

        UserDTO newUser = new UserDTO();
        newUser.setEmail(registerReq.getEmail());
        newUser.setUsername(registerReq.getUsername());
        newUser.setFirstName(registerReq.getFirstName());
        newUser.setLastName(registerReq.getLastName());
        newUser.setEmail(registerReq.getPassword());
        newUser.setRoles(roles);

        String[] recipients = {registerReq.getEmail()};
        String[] cc = {""};
        String[] bcc = {""};

        mailService.sendMail(
                "Complete Registration!",
                "hung.n.61cnttclc@ntu.edu.vn",
                recipients,
                cc,
                bcc,
                "To confirm your account, please click here : ..."
        );

        userService.save(newUser);

        return ResponseEntity.ok(new MessageResponse(
                "User registered successfully! Please check your mail to confirm your account!",
                "success"
        ));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

}
