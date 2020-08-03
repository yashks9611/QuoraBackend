package com.QuoraProject.FeedMicroservice.repository;

import com.QuoraProject.FeedMicroservice.entity.UserRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRelationRepository extends CrudRepository<UserRelation,String> {
}
