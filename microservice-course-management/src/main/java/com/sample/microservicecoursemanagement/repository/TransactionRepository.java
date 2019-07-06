package com.sample.microservicecoursemanagement.repository;

import com.sample.microservicecoursemanagement.model.Transaction;

import java.util.List;

public interface TransactionRepository extends  IGenericDao<Transaction> {
    List<Transaction> findAllTransactionsOfUser(Long id);

    List<Transaction> findAllTransactionsOfCourse(Long courseId);
}
