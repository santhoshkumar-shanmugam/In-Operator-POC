package com.santhosh.springbootdemo.impl;

import com.santhosh.springbootdemo.dto.StudentDTO;
import com.santhosh.springbootdemo.entity.Student;
import com.santhosh.springbootdemo.repo.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRepoImpl  {

    @PersistenceContext
    private EntityManager entityManager;
    public List<StudentDTO> findStudentByIdOption1(List<List<Long>> ids){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentDTO> query = cb.createQuery(StudentDTO.class);
        Root<Student> root = query.from(Student.class);
        Predicate[] pred = new Predicate[ids.size()];
        for(int i = 0 ; i<ids.size() ; i++){
            pred[i]=root.get("id").in(ids.get(i));
        }

        // Select specific fields into the DTO
        query.select(cb.construct(
                        StudentDTO.class,
                        root.get("id"),
                        root.get("name") // Add other fields as necessary
                ))
                .where(cb.or(pred)
                );

        return entityManager.createQuery(query).getResultList();
    }
}
