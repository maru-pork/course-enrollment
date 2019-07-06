package com.sample.microservicecoursemanagement.repository;

import com.sample.microservicecoursemanagement.model.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TransactionRepositoryImpl extends AbstractGenericDao<Transaction> implements TransactionRepository {

    @Override
    public List<Transaction> findAllTransactionsOfUser(final Long userId){
        String hql = "SELECT t FROM transaction t WHERE t.userId = :pUserId";
        Query query = entityManager.createQuery(hql);
        query.setParameter("pUserId", userId);
        return query.getResultList();
    }

    @Override
    public List<Transaction> findAllTransactionsOfCourse(final Long courseId){
        String hql = "SELECT t FROM transaction t WHERE t.courseId = :pCourseId";
        Query query = entityManager.createQuery(hql);
        query.setParameter("pCourseId", courseId);
        return query.getResultList();
    }
}
