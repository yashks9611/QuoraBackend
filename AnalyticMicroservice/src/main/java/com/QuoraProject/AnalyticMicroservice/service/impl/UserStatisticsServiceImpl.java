package com.QuoraProject.AnalyticMicroservice.service.impl;

import com.QuoraProject.AnalyticMicroservice.dto.LikeDislike;
import com.QuoraProject.AnalyticMicroservice.entity.AnswerStatistics;
import com.QuoraProject.AnalyticMicroservice.entity.UserStatistics;
import com.QuoraProject.AnalyticMicroservice.repository.UserStatisticsRepo;
import com.QuoraProject.AnalyticMicroservice.service.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {

    @Autowired
    UserStatisticsRepo userStatisticsRepo;

    @Override
    public UserStatistics findUser(String userId) {
        Optional<UserStatistics> userStatistics= userStatisticsRepo.findById(userId);

        if(userStatistics.isPresent())
            return userStatistics.get();
        else
        {
            UserStatistics userStatistics1=new UserStatistics();
            userStatistics1.setUserId(userId);
            return userStatistics1;
        }
    }

    @Override
    public void addLikeUser(LikeDislike likeDislike) {
        addPoints(likeDislike.getUserId(),1);
    }

    @Override
    public void addDislikeUser(LikeDislike likeDislike) {
        addPoints(likeDislike.getUserId(),-1);
    }

    private void checkUserLevel(UserStatistics userStatistics){

        int userPoints=userStatistics.getUserPoints();
        if(userPoints<1000)
            userStatistics.setUserLevel("Beginner");
        else if(userPoints>=1000 && userPoints<2000)
            userStatistics.setUserLevel("Intermediate");
        else if(userPoints>=2000 && userPoints<3000)
            userStatistics.setUserLevel("Expert");
    }

    @Override
    public void addPoints(String userId, int points) {
        UserStatistics userStatistics=findUser(userId);
        userStatistics.setUserPoints(userStatistics.getUserPoints()+points);
        checkUserLevel(userStatistics);
        userStatisticsRepo.save(userStatistics);
    }

    @Override
    public int getPoints(String userId) {
        UserStatistics userStatistics=findUser(userId);
        return userStatistics.getUserPoints();
    }

    @Override
    public String getUserLevel(String userId) {
        UserStatistics userStatistics=findUser(userId);
        return userStatistics.getUserLevel();

    }
}
