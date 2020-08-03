package com.QuoraProject.QAMicroservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "commentEntity")
public class Comment {

    @Id
    @Indexed(name = "id", type = "string")
    String commentId;

    @Indexed(name = "seniorId", type = "string")
    String seniorId;

    @Indexed(name = "commentContent", type = "string")
    String commentContent;

    @Indexed(name = "userId", type = "string")
    String userId;

    public Comment() {
    }


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(String seniorId) {
        this.seniorId = seniorId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
