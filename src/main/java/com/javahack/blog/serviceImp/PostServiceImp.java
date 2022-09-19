package com.javahack.blog.serviceImp;

import com.javahack.blog.dto.PostDto;
import com.javahack.blog.entity.Post;
import com.javahack.blog.exception.EntityNotFoundException;
import com.javahack.blog.mapper.PostMapper;
import com.javahack.blog.repository.PostRepository;
import com.javahack.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;

    @Override
    public PostDto createPost(PostDto postDto) {
        // Our REST API needs to return PostDto to the client hence we convert the saved Post JPA entity object into PostDto.
        // We need a Post JPA entity to save the post object into the database hence we convert PostDto to a com.javahack.blog.entity.Post JPA entity.

        // convert DTO to entity
        Post post = postMapper.mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = postMapper.mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> postMapper.mapToDTO(post))
                .collect(Collectors.toList());

    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post", "id", id));
        return postMapper.mapToDTO(post);
    }

    //  by default all the methods of JpaRepository are Transactional
    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return postMapper.mapToDTO(updatedPost); //convert to dto for controller
    }

    @Override
    public void deletePost(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post", "id", id));
        postRepository.delete(post);

    }


}
