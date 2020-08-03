package com.QuoraProject.AnalyticMicroservice.controller;

import com.QuoraProject.AnalyticMicroservice.dto.LikeDislike;
import com.QuoraProject.AnalyticMicroservice.entity.AnswerStatistics;
import com.QuoraProject.AnalyticMicroservice.entity.UserStatistics;
import com.QuoraProject.AnalyticMicroservice.repository.AnswerStatisticsRepo;
import com.QuoraProject.AnalyticMicroservice.repository.UserStatisticsRepo;
import com.QuoraProject.AnalyticMicroservice.service.AnswerStatisticsService;
import com.QuoraProject.AnalyticMicroservice.service.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Notification;
import java.util.Map;
import java.util.stream.Stream;

@CrossOrigin("*")
@RestController
@RequestMapping("/Analytic")
public class AnalyticController {

    @Autowired
    AnswerStatisticsService answerStatisticsService;

    @Autowired
    UserStatisticsService userStatisticsService;

    @PostMapping("/like/{userId}")
    void likeButton(@RequestBody LikeDislike likeDislike, @PathVariable("userId") String userId){
        likeDislike.setUserId(userId);
        answerStatisticsService.addLikeAnswer(likeDislike);
        userStatisticsService.addLikeUser(likeDislike);

    }

    @PostMapping("/dislike/{userId}")
    void dislikeButton(@RequestBody LikeDislike likeDislike, @PathVariable("userId") String userId){
        likeDislike.setUserId(userId);
        answerStatisticsService.addDislikeAnswer(likeDislike);
        userStatisticsService.addDislikeUser(likeDislike);
    }

    @PostMapping("/likeagain")
    void likeButtonAgain(@RequestBody LikeDislike likeDislike){
        answerStatisticsService.addLikeAgainAnswer(likeDislike);
        userStatisticsService.addDislikeUser(likeDislike);
    }

    @PostMapping("/dislikeagain")
    void dislikeButtonAgain(@RequestBody LikeDislike likeDislike){
        answerStatisticsService.addDislikeAgainAnswer(likeDislike);
        userStatisticsService.addLikeUser(likeDislike);
    }

    @PostMapping("/points")
    void addPoints(@RequestBody Map<String,Object> map){
        userStatisticsService.addPoints((String) map.get("userID"),(int)map.get("points"));
    }

    @GetMapping("/getPoints/{userId}")
    int getPoints(@PathVariable("userId") String userId)
    {
        return userStatisticsService.getPoints(userId);
    }

    @GetMapping("/getUserLevel")
    String getUserLevel(@PathVariable("userId") String userId)
    {
        return userStatisticsService.getUserLevel(userId);
    }

}
