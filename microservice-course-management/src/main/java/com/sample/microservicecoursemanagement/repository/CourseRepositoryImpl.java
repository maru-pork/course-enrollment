package com.sample.microservicecoursemanagement.repository;

import com.sample.microservicecoursemanagement.model.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CourseRepositoryImpl extends AbstractGenericDao<Course> implements CourseRepository {

    @Override
    public List<Course> filterCourses(final String text) {
        String hql = "SELECT c FROM course c WHERE 1=1 ";
        if (text!=null && "".equals(text.trim())){
            hql += "AND (lower (c.title) LIKE lower (:pText) " +
                            "OR lower (c.category) LIKE lower (:pText) " +
                            "OR lower (c.author) LIKE lower(:pText))";
        }

        Query query = entityManager.createQuery(hql);
        if(text!=null && "".equals(text.trim())){
            query.setParameter("pText", "%"+text+"%");
        }
        return query.getResultList();
    }

    @Override
    public List<Course> filterCourseByIdList(final List<Long> idList){
        String hql = "SELECT c FROM course c WHERE c.id IN (:pIdList)";
        Query query = entityManager.createQuery(hql);
        query.setParameter("pIdList", idList);
        return query.getResultList();
    }
}
