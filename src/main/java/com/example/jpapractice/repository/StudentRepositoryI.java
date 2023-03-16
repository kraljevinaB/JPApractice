package com.example.jpapractice.repository;

import com.example.jpapractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryI extends JpaRepository<Student, Long> {


    Student getStudentByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.guardian.name = ?1")
    List<Student> getStudentByGuardianName(String guardianName);
}
