package com.example.jpastart2;

import com.example.jpastart2.Model.Student;
import com.example.jpastart2.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaStart2ApplicationTests {


    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testStudent(){
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Annex");
        //it will save std1 in database
        studentRepository.save(std1);
        List<Student> lst =studentRepository.findAll();
        assertEquals(3, lst.size());

        studentRepository.delete(std1);
        lst = studentRepository.findAll();
        assertEquals(2,lst.size());

        Optional<Student> opt3 = studentRepository.findById(1);
        if (opt3.isPresent()){
            Student std3 = opt3.get();
            assertEquals(std3.getName(), "Anne");
        }
        opt3 = studentRepository.findByName("viggo");
        if (opt3.isPresent()){
            Student std3 = opt3.get();
            assertEquals(std3.getName(), "viggo");
        }

    }

}
