package com.QuoraProject.AnalyticMicroservice.service.impl;

import com.QuoraProject.AnalyticMicroservice.dto.LikeDislike;
import com.QuoraProject.AnalyticMicroservice.entity.AnswerStatistics;
import com.QuoraProject.AnalyticMicroservice.repository.AnswerStatisticsRepo;
import com.QuoraProject.AnalyticMicroservice.service.AnswerStatisticsService;
import com.QuoraProject.AnalyticMicroservice.service.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerStatisticsServiceImpl implements AnswerStatisticsService {

    @Autowired
    AnswerStatisticsRepo answerStatisticsRepo;

    @Autowired
    UserStatisticsService userStatisticsService;

    @Override
    public AnswerStatistics findAnswer(String answerId) {
        Optional<AnswerStatistics> answerStatistics= answerStatisticsRepo.findById(answerId);

        if(answerStatistics.isPresent())
            return answerStatistics.get();
        else
        {
            AnswerStatistics answerStatistics1=new AnswerStatistics();
            answerStatistics1.setAnswerId(answerId);
            return answerStatistics1;
        }
    }

    @Override
    public void addLikeAnswer(LikeDislike likeDislike) {
        String answerId=likeDislike.getAnswerId();
        AnswerStatistics answerStatistics=findAnswer(answerId);
        answerStatistics.setLikeCount(answerStatistics.getLikeCount()+1);
        checkAnswerAcceptance(answerStatistics,likeDislike);
        answerStatisticsRepo.save(answerStatistics);
    }

    @Override
    public void addDislikeAnswer(LikeDislike likeDislike) {
        String answerId=likeDislike.getAnswerId();
        AnswerStatistics answerStatistics=findAnswer(answerId);
        answerStatistics.setDislikeCount(answerStatistics.getDislikeCount()+1);
        answerStatisticsRepo.save(answerStatistics);
    }

    @Override
    public void addLikeAgainAnswer(LikeDislike likeDislike) {
        String answerId=likeDislike.getAnswerId();
        AnswerStatistics answerStatistics=findAnswer(answerId);
        answerStatistics.setLikeCount(answerStatistics.getLikeCount()-1);
        checkAnswerAcceptance(answerStatistics,likeDislike);
        answerStatisticsRepo.save(answerStatistics);
    }

    @Override
    public void addDislikeAgainAnswer(LikeDislike likeDislike) {
        String answerId=likeDislike.getAnswerId();
        AnswerStatistics answerStatistics=findAnswer(answerId);
        answerStatistics.setDislikeCount(answerStatistics.getDislikeCount()-1);
        answerStatisticsRepo.save(answerStatistics);
    }

    private void checkAnswerAcceptance(AnswerStatistics answerStatistics,LikeDislike likeDislike)
    {
        boolean flagBeforeCheck=answerStatistics.isAcceptedFlag();
        if(answerStatistics.getLikeCount()>10)
            answerStatistics.setAcceptedFlag(true);
        else
            answerStatistics.setAcceptedFlag(false);
        boolean flagAfterCheck=answerStatistics.isAcceptedFlag();

        if(flagAfterCheck!=flagBeforeCheck)
        {
            if(flagAfterCheck)
                userStatisticsService.addPoints(likeDislike.getUserId(),5);
            else
                userStatisticsService.addPoints(likeDislike.getUserId(),-5);
        }
    }


}
