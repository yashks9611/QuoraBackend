package com.QuoraProject.QAMicroservice.controller;

import com.QuoraProject.QAMicroservice.entity.Answer;
import com.QuoraProject.QAMicroservice.repository.AnswerRepository;
import com.QuoraProject.QAMicroservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin("*")
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping("/answer/{userId}")
    public void addAnswer(@PathVariable("userId") String userId,@RequestBody Answer answer)
    {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000000);
        String id="answer"+rand_int1;
        answer.setAnswerId(id);
        answer.setUserId(userId);
        answerService.addAnswer(answer);
    }

    @GetMapping("/answer/{postId}")
    public List<Answer> fetchAnswers(@PathVariable("postId") String postId)
    {
        return answerService.fetchAnswers(postId);
    }

    @Autowired
    AnswerRepository answerRepository;
    @GetMapping("/del")
    public void asda()
    {
        answerRepository.deleteAll();
    }

}
