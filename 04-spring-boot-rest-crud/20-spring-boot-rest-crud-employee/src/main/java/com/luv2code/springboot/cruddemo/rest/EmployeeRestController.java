package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // This block of code is before making refactor for code
//    private EmployeeDAO employeeDAO;

    // quick and dirty: inject employee dao by using (constructor injection)

//    public EmployeeRestController(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
//        return employeeDAO.findAll();
        return employeeService.findAll();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee id not found ~ " + employeeId);
        }
        return theEmployee;
    }

}
