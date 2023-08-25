package com.versolicitud.movieapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
	
    @Async
    public void sendMail(String subject, String from, String[] to, String[] cc, String[] bcc, String text) {
    	SimpleMailMessage mail = new SimpleMailMessage();
    	
    	mail.setSubject(subject);
    	mail.setFrom(from);
    	mail.setTo(to);
    	mail.setCc(cc);
    	mail.setBcc(bcc);
    	mail.setText(text);
    	
//    	mail.setSubject("Complete Registration!");
//    	mail.setFrom("hung.n.61cnttclc@ntu.edu.vn");
//    	mail.setTo("nguyenhung12c1@gmail.com");
//    	mail.setText("To confirm your account, please click here : "
//        		+"http://localhost:3000/confirm-account/");
        javaMailSender.send(mail);
    }
}	
