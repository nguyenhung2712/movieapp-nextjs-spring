package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.BlogDTO;
import com.versolicitud.movieapp.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogMapper {
    BlogMapper MAPPER = Mappers.getMapper(BlogMapper.class);

    Blog mapToEntity(BlogDTO dto);

    BlogDTO mapToDTO(Blog entity);
}
