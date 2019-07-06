package com.sample.microservicecoursemanagement.controller;

import com.sample.microservicecoursemanagement.intercomm.LogClient;
import com.sample.microservicecoursemanagement.intercomm.UserClient;
import com.sample.microservicecoursemanagement.model.Transaction;
import com.sample.microservicecoursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class CourseController {

    @Autowired
    private LogClient logClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private CourseService courseService;

    @PostMapping("/user")
    public ResponseEntity<?> filterTransactions(@RequestBody Long userId){
        return new ResponseEntity<>(courseService.filterTransactionsOfUser(userId), HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<?> popularCourses(){
        List<Long> popularIdList = logClient.getPopularCourses();
        if(popularIdList==null && popularIdList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(courseService.filterCourseByIdList(popularIdList), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> allCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filterCourses(@RequestBody String text) {
        return new ResponseEntity<>(courseService.filterCourses(text), HttpStatus.OK);
    }

    @PostMapping("/enroll")
    private ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction){
        transaction.setDateOfIssue(LocalDateTime.now());
        transaction.setCourse(courseService.findCourseById(transaction.getCourse().getId()));
        courseService.saveTransaction(transaction);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/students")
    public ResponseEntity<?> findCourseStudents(@RequestBody Long courseId){
        List<Transaction> list = courseService.filterTransactionsOfCourse(courseId);
        if(list!=null && !list.isEmpty()){
            List<Long> userIdList = list.parallelStream().map(t->t.getUserId()).collect(Collectors.toList());
            List<String> students = userClient.getUsers(userIdList);
            return ResponseEntity.ok(students);
        }

        return ResponseEntity.notFound().build();
    }
}
