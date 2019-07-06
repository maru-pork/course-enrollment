package com.sample.microservicelogmanagement.controller;

import com.sample.microservicelogmanagement.model.Log;
import com.sample.microservicelogmanagement.model.Summary;
import com.sample.microservicelogmanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/service/create")
    public ResponseEntity<?> saveLog(@RequestBody Log log){
        log.setLogDate(LocalDateTime.now());
        logService.saveOrUpdate(log);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/service/popular")
    public ResponseEntity<?> findPopularCourses(){
        List<Long> idList = null;

        List<Summary> populars = logService.findPopularCourses();
        if(populars!=null){
            idList = populars.parallelStream().map(x->x.getCourseId()).collect(Collectors.toList());
        }

        return ResponseEntity.ok(idList);
    }

    @PostMapping("/service/summary")
    public ResponseEntity<?> getSummaryOfCourse(@RequestBody Long courseId){
        return new ResponseEntity<>(logService.findSummaryByCourseId(courseId), HttpStatus.OK);
    }
}
