package com.versolicitud.movieapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.versolicitud.movieapp.dto.BlogDTO;
import com.versolicitud.movieapp.dto.UserDTO;
import com.versolicitud.movieapp.mapper.BlogMapper;
import com.versolicitud.movieapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versolicitud.movieapp.entity.Blog;
import com.versolicitud.movieapp.entity.User;
import com.versolicitud.movieapp.repository.BlogRepo;
import com.versolicitud.movieapp.service.interfaces.IBlogService;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private UserService userService;

    @Override
    public List<BlogDTO> getAll() {
        return blogRepo.findAll().stream()
                .map(BlogMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BlogDTO getById(UUID id) {
        Optional<Blog> optional = blogRepo.findById(id);
        try {
            Blog blog = optional.orElseThrow(() -> new NoSuchElementException("Blog not found"));
            return BlogMapper.MAPPER.mapToDTO(blog);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public BlogDTO save(BlogDTO blog) {
        UserDTO user = userService.getById(blog.getUser().getId());

        blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        blog.setUser(user);
        Blog savedBlog = BlogMapper.MAPPER.mapToEntity(blog);
        return BlogMapper.MAPPER.mapToDTO(blogRepo.save(savedBlog));
    }

    @Override
    public void delete(UUID id) {
        blogRepo.deleteById(id);
    }

    @Override
    public void toggleStatus(UUID id) {
        Optional<Blog> optional = blogRepo.findById(id);
        try {
            Blog blog = optional.orElseThrow(() -> new NoSuchElementException("Blog not found"));
            int currentStt = blog.getStatus();
            blog.setStatus(currentStt == 1 ? 0 : 1);
            blog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            blogRepo.save(blog);
        } catch (Exception e) {

        }
    }

}
