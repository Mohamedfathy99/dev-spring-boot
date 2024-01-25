package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// This annotation because Spring Boot Data Rest doesn't handle some plural words
// so, we use this annotation for this reason
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

        // that's it .... no need to write any code LoooooL!!!
}
