package com.QuoraProject.AnalyticMicroservice.service;

import com.QuoraProject.AnalyticMicroservice.dto.LikeDislike;
import com.QuoraProject.AnalyticMicroservice.entity.AnswerStatistics;

public interface AnswerStatisticsService{

    AnswerStatistics findAnswer(String answerID);
    void addLikeAnswer(LikeDislike likeDislike);
    void addDislikeAnswer(LikeDislike likeDislike);

    void addLikeAgainAnswer(LikeDislike likeDislike);
    void addDislikeAgainAnswer(LikeDislike likeDislike);
}
