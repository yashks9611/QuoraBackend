package com.QuoraProject.QAMicroservice.service.impl;

import com.QuoraProject.QAMicroservice.entity.Comment;
import com.QuoraProject.QAMicroservice.repository.CommentRepository;
import com.QuoraProject.QAMicroservice.repository.CustomQueryRepository;
import com.QuoraProject.QAMicroservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CustomQueryRepository customQueryRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> fetchComments(String parentId) {
        return customQueryRepository.fetchComments(parentId);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
