package com.santhosh.springbootdemo;

import com.santhosh.springbootdemo.entity.Student;
import com.santhosh.springbootdemo.repo.DummyTableRepo;
import com.santhosh.springbootdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private DummyTableRepo dummyTableRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

@Bean
	public CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Student> list = new ArrayList<>();
				dummyTableRepo.deleteAll();
				studentRepository.deleteAll();
				for(long i = 1 ; i<2100;i++){
					list.add(new Student("test"+i));
				}
				studentRepository.saveAll(list);

			}
		};
	}
}
