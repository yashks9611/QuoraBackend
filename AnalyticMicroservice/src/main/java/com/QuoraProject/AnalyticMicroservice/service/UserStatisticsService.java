package com.QuoraProject.AnalyticMicroservice.service;

import com.QuoraProject.AnalyticMicroservice.dto.LikeDislike;
import com.QuoraProject.AnalyticMicroservice.entity.UserStatistics;

public interface UserStatisticsService {

    void addLikeUser(LikeDislike likeDislike);
    void addDislikeUser(LikeDislike likeDislike);
    UserStatistics findUser(String userId);
    void addPoints(String userId,int points);
    int getPoints(String userId);
    String getUserLevel(String userId);
}
