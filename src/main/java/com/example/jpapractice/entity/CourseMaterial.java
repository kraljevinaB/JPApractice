package com.example.jpapractice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(name = "course_Id", referencedColumnName = "courseId")
    private Course course;
}
