package com.QuoraProject.FeedMicroservice.service.impl;

import com.QuoraProject.FeedMicroservice.entity.UserRelation;
import com.QuoraProject.FeedMicroservice.repository.UserRelationRepository;
import com.QuoraProject.FeedMicroservice.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRelationServiceImpl implements UserRelationService {

    @Autowired
    UserRelationRepository userRelationRepository;

    @Override
    public UserRelation findUser(String userId) {
        Optional<UserRelation> userRelation=userRelationRepository.findById(userId);
        if(userRelation.isPresent())
            return userRelation.get();
        else
        {
            UserRelation userRelation1=new UserRelation();
            userRelation1.setUserId(userId);
            return userRelation1;
        }
    }

    @Override
    public void follow(String followId, String userId) {
        UserRelation userRelation=findUser(userId);
        UserRelation followRelation=findUser(followId);
        ArrayList<String> list=followRelation.getFollowers();
        list.add(userId);
        followRelation.setFollowers(list);

        ArrayList<String> list1=userRelation.getFollowing();
        list1.add(followId);
        userRelation.setFollowing(list1);
        System.out.println(list+"  "+list1);
        userRelationRepository.save(userRelation);
        userRelationRepository.save(followRelation);
    }

    @Override
    public void unfollow(String userId, String followId) {
        UserRelation userRelation=findUser(userId);
        UserRelation followRelation=findUser(followId);
        ArrayList<String> list=followRelation.getFollowers();
        list.remove(userId);
        followRelation.setFollowers(list);

        ArrayList<String> list1=userRelation.getFollowing();
        list1.remove(followId);
        userRelation.setFollowing(list1);
        userRelationRepository.save(userRelation);
        userRelationRepository.save(followRelation);
    }

    @Override
    public ArrayList<String> getFollowers(String userId)
    {
        UserRelation userRelation=findUser(userId);
        return userRelation.getFollowers();
    }

    @Override
    public ArrayList<String> getFollowing(String userId)
    {
        UserRelation userRelation=findUser(userId);
        return userRelation.getFollowing();
    }

    @Override
    public List<String> getCategories(String userId) {
        UserRelation userRelation=findUser(userId);
        return userRelation.getCategory();
    }

    @Override
    public void addCategory(String userId,String category) {
        UserRelation userRelation=findUser(userId);
        ArrayList<String> list1=userRelation.getCategory();
        list1.add(category);
        userRelation.setFollowing(list1);
        userRelationRepository.save(userRelation);
    }
}
