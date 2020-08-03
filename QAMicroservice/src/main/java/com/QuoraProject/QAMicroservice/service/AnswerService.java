package com.QuoraProject.QAMicroservice.service;

import com.QuoraProject.QAMicroservice.entity.Answer;
import java.util.List;

public interface AnswerService {

    void addAnswer(Answer answer);
    List<Answer> fetchAnswers(String postID);
}
