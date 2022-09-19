package com.javahack.blog.mapper;

import com.javahack.blog.dto.CommentDto;
import com.javahack.blog.entity.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

//1- added mapper dependency
//2- added  Model Mapper Configuration in @SpringBootApplication class
//  because @SpringBootApplication class has a Configuration component
//3- create comment and post mapper classes inject ModelMapper and create converting methods
//4- now, we can use converting methods in service classes
//5- ModelMapper use toString() method, so we have to use just @Getter @Setter not @Data in entity classes
// otherwise we get stackoverflow error because infinite loop

@Component
public class CommentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CommentDto mapToDTO(Comment comment) {
        CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
        return commentDto;
    }

    public Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }

}
