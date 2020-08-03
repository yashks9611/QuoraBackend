package com.QuoraProject.QAMicroservice.controller;

import com.QuoraProject.QAMicroservice.entity.Comment;
import com.QuoraProject.QAMicroservice.repository.AnswerRepository;
import com.QuoraProject.QAMicroservice.repository.CommentRepository;
import com.QuoraProject.QAMicroservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin("*")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comment/{userId}")
    public void addComment(@RequestBody Comment comment,@PathVariable("userId") String userId)
    {

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000000);
        String id="comment"+rand_int1;
        comment.setCommentId(id);
        comment.setUserId(userId);
        commentService.addComment(comment);
    }

    @GetMapping("/comment/{parentId}")
    public List<Comment> fetchComments(@PathVariable("parentId") String parentId)
    {
        return commentService.fetchComments(parentId);
    }

    @Autowired
    CommentRepository commentRepository;
    @GetMapping("/delc")
    public void asda()
    {
        commentRepository.deleteAll();
    }

}
