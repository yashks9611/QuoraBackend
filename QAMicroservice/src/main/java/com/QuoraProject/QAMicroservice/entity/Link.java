package com.QuoraProject.QAMicroservice.entity;

public class Link {

    String userID;
    int points;

    public Link() {
    }

    public Link(String userID, int points) {
        this.userID = userID;
        this.points = points;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
