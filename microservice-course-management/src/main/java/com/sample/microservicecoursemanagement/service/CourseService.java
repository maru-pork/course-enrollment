package com.sample.microservicecoursemanagement.service;

import com.sample.microservicecoursemanagement.model.Course;
import com.sample.microservicecoursemanagement.model.Transaction;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    List<Course> filterCourseByIdList(List<Long> idList);

    List<Course> filterCourses(String content);

    List<Transaction> filterTransactionsOfUser(Long userId);

    List<Transaction> filterTransactionsOfCourse(Long courseId);

    void saveTransaction(Transaction transaction);

    Course findCourseById(Long courseId);
}
