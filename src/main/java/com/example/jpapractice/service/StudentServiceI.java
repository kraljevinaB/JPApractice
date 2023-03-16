package com.example.jpapractice.service;

import com.example.jpapractice.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentServiceI {
    Student findStudentById(Long id);

    List<Student> findAllStudents();

    void saveStudent(Student student);

    boolean deleteStudentById(Long id);

    Student getStudentByFirstNameAndLastName(String firstName, String lastName);

    List<Student> getStudentsByGuardianName(String name);
}
