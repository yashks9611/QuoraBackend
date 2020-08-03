package com.QuoraProject.AnalyticMicroservice.repository;

import com.QuoraProject.AnalyticMicroservice.entity.UserStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatisticsRepo extends CrudRepository<UserStatistics,String> {

}
