package com.sample.microservicelogmanagement.service;

import com.sample.microservicelogmanagement.model.Log;
import com.sample.microservicelogmanagement.model.Summary;
import com.sample.microservicelogmanagement.repository.LogRepository;
import com.sample.microservicelogmanagement.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Override
    public Log saveOrUpdate(Log log){
        Summary existingSummary = summaryRepository.findByCourseId(log.getCourseId()).orElse(null);
        if(existingSummary!=null){
            // Note: In Cassandra, you can only update non primary key values
            summaryRepository.delete(existingSummary);
            existingSummary.setHitCount(existingSummary.getHitCount()+1);
            summaryRepository.save(existingSummary);
        }else {
            Summary summary = new Summary();
            summary.setCourseId(log.getCourseId());
            summary.setHitCount(1l);
            summaryRepository.save(summary);
        }

        log.setId(UUID.randomUUID());
        logRepository.save(log);
        return log;
    }


    @Override
    public List<Summary> findPopularCourses(){
        return summaryRepository.findPopularCourses();
    }

    @Override
    public Summary findSummaryByCourseId(Long courseId){
        return summaryRepository.findByCourseId(courseId).orElse(null);
    }


}
