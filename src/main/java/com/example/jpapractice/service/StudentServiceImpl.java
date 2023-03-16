package com.example.jpapractice.service;

import com.example.jpapractice.entity.Student;
import com.example.jpapractice.repository.StudentRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceI{

    @Autowired
    StudentRepositoryI studentRepository;

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public boolean deleteStudentById(Long id) {
        try{
            studentRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Student getStudentByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.getStudentByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Student> getStudentsByGuardianName(String name) {
        return studentRepository.getStudentByGuardianName(name);
    }
}
