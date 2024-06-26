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
//			createInstructor(appDAO);

//			findInstructor(appDAO);

			deleteInstructor(appDAO);

		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Deleting Constructor id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Deleted Done!");

	}

	private void findInstructor(AppDAO appDAO) {

		int id = 2;
		System.out.println("Finding Constructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associate instructorDetail only: "+
				tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

        /*
		// Create the instructor
		Instructor tempInstructor =
				new Instructor("Mohamed", "Fathy", "fathy@gmail.com");

		// Create the InstructorDetail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.fathy.com/youtube",
						"football & love 2 Coding!!!! "
				);
       */
		// Create the instructor
		Instructor tempInstructor =
				new Instructor("Yousef", "Fathy", "yousef@gmail.com");

		// Create the InstructorDetail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.yousef.com/youtube",
						"football & love gaming!!!! "
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
