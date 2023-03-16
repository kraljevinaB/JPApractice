package com.example.jpapractice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id", referencedColumnName =  "teacherId")
//    private List<Course> courses;
}
