package com.QuoraProject.FeedMicroservice.controller;

import com.QuoraProject.FeedMicroservice.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "*", methods = { RequestMethod.PUT , RequestMethod.GET , RequestMethod.POST } )
@RestController
@RequestMapping("/Relation")
public class RelationController {

    @Autowired
    UserRelationService userRelationService;

    @GetMapping("/follower/{userId}")
    List<String> getFollowers(@PathVariable("userId") String userId)
    {
        System.out.println(userRelationService.getFollowers(userId));
        return userRelationService.getFollowers(userId);
    }

    @PostMapping("/follow/{followId}")
    void followUser(@PathVariable("followId") String followId,@RequestBody String userId)
    {
        userRelationService.follow(followId,userId);
    }


    @GetMapping("/following/{userId}")
    List<String> getFollowing(@PathVariable("userId") String userId)
    {
        return userRelationService.getFollowing(userId);
    }

    @PostMapping("/unfollow/{followId}")
    void removeFollower(@RequestBody String userId,@PathVariable("followId") String followId)
    {
        userRelationService.unfollow(userId,followId);
    }


    @GetMapping("/category")
    List<String> getCategories(@RequestBody String userId)
    {
        return userRelationService.getCategories(userId);
    }

    @PostMapping("/addcategory/{categoty}")
    void addCategory(@RequestBody String userId,@PathVariable("cateory") String category)
    {
        userRelationService.addCategory(userId,category);
    }




}
