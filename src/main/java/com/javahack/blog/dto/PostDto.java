package com.javahack.blog.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;

    // we need to also return a set of comments to the client
    //Now, Mapper will take care of mapping post comments with postDto
    private Set<CommentDto> comments;

}
