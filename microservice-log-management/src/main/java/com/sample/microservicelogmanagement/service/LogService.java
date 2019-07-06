package com.sample.microservicelogmanagement.service;

import com.sample.microservicelogmanagement.model.Log;
import com.sample.microservicelogmanagement.model.Summary;

import java.util.List;

public interface LogService {

    Log saveOrUpdate(Log log);

    List<Summary> findPopularCourses();

    Summary findSummaryByCourseId(Long courseId);
}
