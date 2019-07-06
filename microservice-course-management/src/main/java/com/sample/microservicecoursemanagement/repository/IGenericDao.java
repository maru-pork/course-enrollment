package com.sample.microservicecoursemanagement.repository;

import com.sample.microservicecoursemanagement.model.IModel;
import org.hibernate.Session;

import java.util.List;

public interface IGenericDao<T extends IModel> {
    T find(Long id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(Long id);

    Session getSession();
}
