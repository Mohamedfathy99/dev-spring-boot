package com.springbootrestapi.demo.rest;


import com.springbootrestapi.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define a field, load the field with data. do it only once

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Mohamed", "Fathy"));
        theStudents.add(new Student("Ahmed", "Karim"));
        theStudents.add(new Student("Ali", "yousef"));
    }

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // define endpoint or "/students/{studentId}" ~ return at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Just index into the list ... keep it simple for now

        return theStudents.get(studentId);
    }

}







