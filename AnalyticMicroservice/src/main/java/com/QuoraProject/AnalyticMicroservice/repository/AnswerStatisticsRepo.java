package com.QuoraProject.AnalyticMicroservice.repository;

import com.QuoraProject.AnalyticMicroservice.entity.AnswerStatistics;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerStatisticsRepo extends SolrCrudRepository<AnswerStatistics,String> {
}
