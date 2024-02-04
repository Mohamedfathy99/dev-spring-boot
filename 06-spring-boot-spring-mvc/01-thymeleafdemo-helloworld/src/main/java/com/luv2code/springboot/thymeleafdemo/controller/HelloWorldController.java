package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read data from and
    // add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

//        We don't need this code now because spring do it behind the scenes for us
//        after add @RequestParam("studentName")
//        read the request parameter from the HTML form

//        String theName = request.getParameter("studentName");

        // convert the data to all uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey My Friend! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }



}
