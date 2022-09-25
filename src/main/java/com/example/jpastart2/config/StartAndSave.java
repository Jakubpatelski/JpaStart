package com.example.jpastart2.config;

import com.example.jpastart2.Model.Student;
import com.example.jpastart2.repository.StudentRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartAndSave implements CommandLineRunner {


    StudentRepository studentRepository;

    @Autowired
    public StartAndSave(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Anne");
        //it will save std1 in database
        studentRepository.save(std1);

        Student std2 = new Student();
        std2.setBorn(LocalDate.now().plusDays(1000));
        std2.setName("viggo");
        //it will save std2 in database
        studentRepository.save(std2);
    }
}
