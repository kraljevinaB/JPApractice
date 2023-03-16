package com.example.jpapractice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;
}
