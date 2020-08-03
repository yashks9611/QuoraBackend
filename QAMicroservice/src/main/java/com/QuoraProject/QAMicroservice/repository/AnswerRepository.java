package com.QuoraProject.QAMicroservice.repository;

import com.QuoraProject.QAMicroservice.entity.Answer;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends SolrCrudRepository<Answer,String> {
}
