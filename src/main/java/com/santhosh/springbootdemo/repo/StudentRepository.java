package com.santhosh.springbootdemo.repo;

import com.santhosh.springbootdemo.dto.StudentDTO;
import com.santhosh.springbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new com.santhosh.springbootdemo.dto.StudentDTO(st.id,st.name) FROM Student st WHERE id in :ids")
    List<StudentDTO> findStudentById(List<Long> ids);
}
