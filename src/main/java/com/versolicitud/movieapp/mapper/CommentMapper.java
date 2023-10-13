package com.versolicitud.movieapp.mapper;

import com.versolicitud.movieapp.dto.CommentDTO;
import com.versolicitud.movieapp.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper MAPPER = Mappers.getMapper(CommentMapper.class);

    Comment mapToEntity(CommentDTO dto);

    CommentDTO mapToDTO(Comment entity);
}
