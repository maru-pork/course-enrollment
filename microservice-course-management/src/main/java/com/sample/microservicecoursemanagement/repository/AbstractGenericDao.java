package com.sample.microservicecoursemanagement.repository;

import com.sample.microservicecoursemanagement.model.IModel;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public class AbstractGenericDao<T extends IModel> implements IGenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> entityClass =
            (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public T find(Long id){
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll(){
        final List<T> resultList = this.entityManager.createQuery("SELECT v FROM " + this.entityClass.getCanonicalName() + " v").getResultList();
        return resultList;
    }

    @Override
    public  void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity){
        entityManager.merge(entity);
    }

    @Override
    public void delete(final Long id){
        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    @Override
    public Session getSession(){
        return (Session) this.entityManager.getDelegate();
    }
}
