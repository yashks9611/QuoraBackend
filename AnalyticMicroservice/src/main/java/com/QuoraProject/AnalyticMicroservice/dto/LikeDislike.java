package com.QuoraProject.AnalyticMicroservice.dto;

public class LikeDislike {

    String answerId;

    String userId;

    public LikeDislike() {
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
