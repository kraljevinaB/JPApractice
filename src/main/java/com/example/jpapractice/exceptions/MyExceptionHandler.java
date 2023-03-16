package com.example.jpapractice.exceptions;

import com.example.jpapractice.exceptionFormat.ExceptionFormatPrint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@ResponseStatus
public class MyExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ExceptionFormatPrint> handler(StudentNotFoundException studentNotFoundException, WebRequest webRequest){
        ExceptionFormatPrint message = new ExceptionFormatPrint(HttpStatus.NOT_FOUND.toString(), "moja kompanija", LocalDate.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
