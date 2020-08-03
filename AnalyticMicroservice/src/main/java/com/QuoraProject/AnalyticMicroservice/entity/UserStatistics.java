package com.QuoraProject.AnalyticMicroservice.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userStats")
public class UserStatistics {

    @Id
    @Column(name = "Id")
    String userId;
    int userPoints;
    String userLevel;

    public UserStatistics() {
        this.userPoints=0;
        this.userLevel="Beginner";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
}
