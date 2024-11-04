package com.santhosh.springbootdemo.controller;

import com.santhosh.springbootdemo.dto.StudentDTO;
import com.santhosh.springbootdemo.entity.Student;
import com.santhosh.springbootdemo.impl.StudentRepoImpl;
import com.santhosh.springbootdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
    private StudentRepoImpl studentRepository;

    @GetMapping("/")
    public List<StudentDTO> getStudent(){
        List<List<Long>> list = new ArrayList<>();
        List<Long> list1 = new ArrayList<>();
        for (long i = 1 ;i<1000; i++){
            list1.add(i);
        }
        list.add(list1);
        List<Long> list2 = new ArrayList<>();
        for (long i = 1 ;i<1200; i++){
            list2.add(i);
        }
        list.add(list2);
        return studentRepository.findStudentById(list);
    }
}
