package com.QuoraProject.QAMicroservice.service.impl;

import com.QuoraProject.QAMicroservice.entity.Link;
import com.QuoraProject.QAMicroservice.entity.Post;
import com.QuoraProject.QAMicroservice.repository.CustomQueryRepository;
import com.QuoraProject.QAMicroservice.repository.QuestionRepository;
import com.QuoraProject.QAMicroservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CustomQueryRepository customQueryRepository;

    private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    private final RestTemplate restTemplate = restTemplateBuilder.build();


    @Override
    public Post addPost(Post post) {
        return questionRepository.save(post);
//         createPost(post.getUserID());
    }


    public Link createPost(String userId) {
        String url = "http://localhost:8081/Analytic/points";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Link link = new Link(userId, 10);
        HttpEntity<Link> entity = new HttpEntity<>(link, headers);
        return restTemplate.postForObject(url, entity, Link.class);
    }

    @Override
    public List<Post> getPosts(String userId) {
        return customQueryRepository.fetchPosts(userId);
    }

    /*@Override
    public List<Post> getPostsOfFollowing(String userId)
    {
        Users currentuser=userRepository.findByUserid(userId);
        ArrayList<Integer> arr=currentuser.getFollowing();
        ArrayList<Post> list=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            Users user=userRepository.findByUserid(arr.get(i));
            List<Post> posts=QuestionRepository.findByUser(user);
            list.addAll(posts);
        }
        return list;
        /*List<Post> publicposts= blogService.getpublicposts();
        list.addAll(publicposts);
        return list;*/
    //}

    public List<Post> getPostsOfFollowing(String userId)
    {
        String url = "http://localhost:8082/Relation/following/"+userId;
        List<String> data=this.restTemplate.getForObject(url, List.class);
        List<Post> postOfFollowing=new ArrayList<Post>();

        for(int i=0;i<data.size();i++)
        {
            postOfFollowing=Stream.concat(postOfFollowing.stream(), getPosts(data.get(i)).stream())
                    .collect(Collectors.toList());
        }

        return  postOfFollowing;
    }

}

