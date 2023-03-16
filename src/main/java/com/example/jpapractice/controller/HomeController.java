package com.example.jpapractice.controller;


import com.example.jpapractice.entity.Student;
import com.example.jpapractice.exceptions.StudentNotFoundException;
import com.example.jpapractice.service.StudentServiceI;
import com.example.jpapractice.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    StudentServiceI studentService;

    @GetMapping(value = "/")
    public String home(){
        return "Sve ok";
    }

    @GetMapping(value = "/students/{id}")
    public Student findStudentById(@PathVariable Long id) throws StudentNotFoundException {
        try{
            return studentService.findStudentById(id);
        }catch (Exception e){
            throw new StudentNotFoundException("Uneseni id je veci od broja studenata u bazi");
        }
    }

    @GetMapping(value = "/students/{firstName}/{lastName}")
    public Student getStudentByFirstNameAndLastName(@PathVariable(name = "firstName") String firstName, @PathVariable(name = "lastName") String lastName){
        return studentService.getStudentByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping(value = "/students/guardian/{name}")
    public List<Student> getStudentsByGuardianName(@PathVariable(name = "name") String name){
        return studentService.getStudentsByGuardianName(name);
    }

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() throws StudentNotFoundException {
        try{
            return studentService.findAllStudents();
        }catch (Exception e){
            throw new StudentNotFoundException("Nisu nadjeni studenti, baza je prazna.");
        }
    }

    @PostMapping(value = "/students")
    public ResponseEntity saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity deleteStudentById(@PathVariable Long id){
        if (studentService.deleteStudentById(id))
            return ResponseEntity.status(HttpStatus.OK).body("Student sa unesenim Id je nadjen i obrisan.");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student sa tim Id nije nadjen. Pokusajte drugi.");
    }


}
