package com.versolicitud.movieapp.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.versolicitud.movieapp.dto.BlogDTO;

public interface IBlogService {
    List<BlogDTO> getAll();

    BlogDTO getById(UUID id);

    BlogDTO save(BlogDTO blog);

    void delete(UUID id);

    void toggleStatus(UUID id);
}
