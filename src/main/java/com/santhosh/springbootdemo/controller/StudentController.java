package com.santhosh.springbootdemo.controller;

import com.google.common.collect.Lists;
import com.santhosh.springbootdemo.dto.StudentDTO;
import com.santhosh.springbootdemo.entity.DummyTable;
import com.santhosh.springbootdemo.entity.Student;
import com.santhosh.springbootdemo.impl.StudentRepoImpl;
import com.santhosh.springbootdemo.repo.DummyTableRepo;
import com.santhosh.springbootdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
    private StudentRepoImpl studentRepositoryImpl;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DummyTableRepo dummyTableRepo;

    @GetMapping("/test")
    public List<StudentDTO> getStudentTest(){
        List<Long> list = new ArrayList<>();
        for (long i = 1 ;i<2100; i++){
            list.add(i);
        }
        return studentRepository.findStudentById(list);
    }


    @GetMapping("/option1/")
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
        return studentRepositoryImpl.findStudentByIdOption1(list);
    }


    @GetMapping("/option2")
    public List<StudentDTO> getStudentOption2(){
        List<Long> list = new ArrayList<>();
        List<StudentDTO> mainList = new ArrayList<>();
        for (long i = 1 ;i<2500; i++){
            list.add(i);
        }
        List<List<Long>> subList = Lists.partition(list, 2099);

        for(List<Long> sub : subList) {
            mainList.addAll(studentRepository.findStudentById(sub));
        }
        return mainList;
    }


    @GetMapping("/option3")
    public List<StudentDTO> getStudentOption3(){

        List<Student> studentList = studentRepository.findAll();

        List<Long> list = new ArrayList<>();
        for (long i = 1 ;i<2500; i++){
            list.add(i);
        }

        List<DummyTable> list1 = new ArrayList<>();
        studentList.forEach(obj->{
            list1.add(new DummyTable(obj.getId()));
        });

        dummyTableRepo.saveAll(list1);
        return studentRepository.findStudents();

    }


}
