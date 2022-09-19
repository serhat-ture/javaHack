package com.javahack.blog.mapper;

import com.javahack.blog.dto.PostDto;
import com.javahack.blog.entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PostMapper {

    @Autowired
    private ModelMapper modelMapper;

    // convert Entity into DTO
    public PostDto mapToDTO(Post post) {
        PostDto postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }

    // convert DTO to entity
    public Post mapToEntity(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }
}
