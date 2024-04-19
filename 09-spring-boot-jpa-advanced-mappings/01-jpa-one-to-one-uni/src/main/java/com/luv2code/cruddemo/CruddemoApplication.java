package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {


		// Create the instructor
		Instructor tempInstructor =
				new Instructor("Mohamed", "Fathy", "fathy@gmail.com");

		// Create the InstructorDetail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.fathy.com/youtube",
						"football & love 2 Coding!!!! "
				);
		// associate these two objects together with oneToOne relationship
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// Note: this will ALSO save the instructorDetails objects
		// because of cascadeType.ALL
		//
		System.out.println("Saving the instructor: "+ tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
