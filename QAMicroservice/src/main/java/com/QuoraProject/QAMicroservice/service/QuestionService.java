package com.QuoraProject.QAMicroservice.service;

import com.QuoraProject.QAMicroservice.entity.Post;
import javafx.geometry.Pos;

import java.util.List;


public interface QuestionService {

    Post addPost(Post post);
    List<Post> getPosts(String userId);
    List<Post> getPostsOfFollowing(String userId);
}
