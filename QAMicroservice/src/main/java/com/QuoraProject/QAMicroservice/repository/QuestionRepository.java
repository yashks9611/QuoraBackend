package com.QuoraProject.QAMicroservice.repository;

import com.QuoraProject.QAMicroservice.entity.Post;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends SolrCrudRepository<Post,String> {

   /* List<Post> findByUser(Users user);*/

}
