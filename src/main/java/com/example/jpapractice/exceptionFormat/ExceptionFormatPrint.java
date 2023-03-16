package com.example.jpapractice.exceptionFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExceptionFormatPrint {
    private String text;
    private String company = "Isah Rikovic Tech company";
    private LocalDate date;
}
