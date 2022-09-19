package com.javahack.blog.serviceImp;

import com.javahack.blog.dto.CommentDto;
import com.javahack.blog.entity.Comment;
import com.javahack.blog.entity.Post;
import com.javahack.blog.exception.EntityNotFoundException;
import com.javahack.blog.mapper.CommentMapper;
import com.javahack.blog.repository.CommentRepository;
import com.javahack.blog.repository.PostRepository;
import com.javahack.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Comment comment = commentMapper.mapToEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post", "id", postId));
        //we are maintaining postId in comments table
        comment.setPost(post);
        // comment entity to DB
        Comment newComment = commentRepository.save(comment);
        return commentMapper.mapToDTO(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        //we need list of comment entities
        List<Comment> comments = commentRepository.findByPostId(postId);
        // convert list of comment entities to list of comment dto's
        return comments.stream().map(comment -> commentMapper.mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("Comment", "id", commentId));
        return commentMapper.mapToDTO(comment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("Comment", "id", commentId));
        commentRepository.delete(comment);
    }

    //  by default all the methods of JpaRepository are Transactional
    @Override
    public CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest) {
        //first we get to postId
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new EntityNotFoundException("Comment", "id", commentId));
        //set to update comment entity
        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setCommentBody(commentRequest.getCommentBody());
        Comment updatedComment = commentRepository.save(comment);
        return commentMapper.mapToDTO(updatedComment);
    }


}
