package com.QuoraProject.QAMicroservice.repository;

import com.QuoraProject.QAMicroservice.entity.Answer;
import com.QuoraProject.QAMicroservice.entity.Comment;
import com.QuoraProject.QAMicroservice.entity.Post;

import java.util.List;

public interface CustomQueryRepository {

    List<Answer> fetchAnswers(String postId);
    List<Comment> fetchComments(String parentId);
    List<Post> fetchPosts(String userId);
}
