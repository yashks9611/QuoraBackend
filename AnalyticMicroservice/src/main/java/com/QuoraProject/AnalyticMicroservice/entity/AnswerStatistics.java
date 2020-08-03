package com.QuoraProject.AnalyticMicroservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;



@SolrDocument(collection = "answerStatistics")
public class AnswerStatistics {

    @Id
    @Indexed(name = "id",type = "string")
    String answerId;

    @Indexed(name="acceptedFlag", type = "boolean")
    boolean acceptedFlag;

    @Indexed(name = "likeCount",type="int")
    int likeCount;

    @Indexed(name = "dislikeCount",type = "int")
    int dislikeCount;

    public AnswerStatistics() {
        this.acceptedFlag=false;
        this.likeCount=0;
        this.dislikeCount=0;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public boolean isAcceptedFlag() {
        return acceptedFlag;
    }

    public void setAcceptedFlag(boolean acceptedFlag) {
        this.acceptedFlag = acceptedFlag;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }



}
