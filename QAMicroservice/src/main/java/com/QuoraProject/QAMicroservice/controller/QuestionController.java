package com.QuoraProject.QAMicroservice.controller;

import com.QuoraProject.QAMicroservice.entity.Link;
import com.QuoraProject.QAMicroservice.entity.Post;
import com.QuoraProject.QAMicroservice.repository.AnswerRepository;
import com.QuoraProject.QAMicroservice.repository.QuestionRepository;
import com.QuoraProject.QAMicroservice.service.QuestionService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Random;

@CrossOrigin( origins = "*",allowedHeaders = "*",allowCredentials = "true",methods = { RequestMethod.PUT , RequestMethod.GET , RequestMethod.POST } )
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("/post/{userId}")
    public Post addPost(@RequestBody Post post,@PathVariable("userId") String userId)
    {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000000);
        String id="post"+rand_int1;
        post.setPostId(id);
        post.setUserId(userId);
        return questionService.addPost(post);
    }

    @GetMapping("/post/{userId}")
    public List<Post> getPosts(@PathVariable("userId") String userId)
    {
        return questionService.getPosts(userId);
    }

    @GetMapping("/del")
    public void asda()
    {
        questionRepository.deleteAll();
    }

  /* @GetMapping("/getPostsOfFollowing/{userId}")
    public List<Post> getFollowingPosts(@PathVariable("userId") String userId)
    {
        return questionService.getPostsOfFollowing(userId);
    }*/

    @GetMapping("/postoffollowing/{userId}")
    public List<Post> getPostsOfFollowing(@PathVariable("userId") String userId)
    {
            return questionService.getPostsOfFollowing(userId);
    }

}
