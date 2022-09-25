package com.example.jpastart2.repository;

import com.example.jpastart2.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student, Integer> {
    Optional<Student> findByName(String name);

}
