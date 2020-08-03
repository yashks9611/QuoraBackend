package com.QuoraProject.QAMicroservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.sql.Date;

@SolrDocument(solrCoreName = "postEntity")
public class Post {

    @Id
    @Indexed(name = "id", type = "string")
    String postId;

    @Indexed(name = "category", type = "string")
    String category;

    @Indexed(name = "date", type = "date")
    Date dateCreated;

    @Indexed(name = "userId", type = "string")
    String userId;

    @Indexed(name = "postContent", type = "string")
    String postContent;

    public Post() {
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
