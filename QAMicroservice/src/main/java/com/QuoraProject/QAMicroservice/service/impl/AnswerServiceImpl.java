package com.QuoraProject.QAMicroservice.service.impl;

import com.QuoraProject.QAMicroservice.entity.Answer;
import com.QuoraProject.QAMicroservice.repository.AnswerRepository;
import com.QuoraProject.QAMicroservice.repository.CustomQueryRepository;
import com.QuoraProject.QAMicroservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CustomQueryRepository customQueryRepository;

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public List<Answer> fetchAnswers(String postId) {
        return customQueryRepository.fetchAnswers(postId);
    }
}
