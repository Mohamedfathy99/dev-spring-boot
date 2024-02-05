package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    // need a controller method to show the initial HTML form
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create a new student object
        Student theStudent = new Student();
        // add student object to the model attribute->
        // (name of the attribute, value of the attribute )
        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    // That is the same name as used in actual html form
    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName()
                + " " + theStudent.getLastName());

        return "student-confirmation";
    }


}
















