package com.QuoraProject.FeedMicroservice.service;

import com.QuoraProject.FeedMicroservice.entity.UserRelation;

import java.util.List;

public interface UserRelationService {

    UserRelation findUser(String userId);
    void follow(String userId,String followId);
    void unfollow(String userId,String followId);
    List<String> getFollowers(String userId);
    List<String> getFollowing(String userId);
    List<String> getCategories(String userId);
    void addCategory(String userId,String category);
}
