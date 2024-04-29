package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private static final Logger log = LoggerFactory.getLogger(CruddemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {

//			createCourseAndStudents(appDAO);

//			findCoursesAndStudents(appDAO);

//			findStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int id = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

		// create more courses for student
		Course tempCourse1 = new Course("Rubik's Cube - How to speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int id = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("Done!");

	}

	private void findCoursesAndStudents(AppDAO appDAO) {

		int id = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		// create the students
		Student tempStudents1 = new Student("Mohamed", "Fathy", "mohamed@gmail.com");
		Student tempStudents2 = new Student("Yousef", "Fathy", "yousef@gmail.com");

		// add students to the course
		tempCourse.addStudent(tempStudents1);
		tempCourse.addStudent(tempStudents2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int id = 10;

		System.out.println("Deleting course id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int id = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(id);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");
		// add some reviews
		tempCourse.addReview(new Review("Great Course ... loved it!!"));
		tempCourse.addReview(new Review("Cool course, job well done."));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course .... and leverage cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {

		int id = 10;
		System.out.println("Deleting Course id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Deleted Done!");

	}

	private void updateCourse(AppDAO appDAO) {


		int id = 10;

		// find the course
		System.out.println("Finding Course id: "+ id);
		Course tempCourse = appDAO.findCourseById(id);

		// update some data for Course
		System.out.println("Updating Course id: " + id);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {

		int id = 1;
		
		// find the instructor
		System.out.println("Finding instructor id: "+ id);
		Instructor tempInstructor = appDAO.findInstructorById(id);

		// update some data for instructor
		System.out.println("Updating instructor id: " + id);
		tempInstructor.setFirstName("Mohamed");
		tempInstructor.setLastName("Fathy");

		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associated courses: "+ tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		// find instructor
		System.out.println("Finding instructor id: "+ id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: "+ tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: "+id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// associate the objects
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: "+ tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor id: "+ id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("The associated courses: "+tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// Create the instructor
		Instructor tempInstructor =
				new Instructor("Mohamed", "Fathy", "mohamed.fathy@gmail.com");

		// Create the InstructorDetail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"football & love Video Games!!!! "
				);
		// associate these two objects together with oneToOne relationship
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// Note: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: "+ tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 3;
		System.out.println("Deleting instructor Detail id: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Deleted Done!");


	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int id = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);

		// print the instructor detail
		System.out.println(" Instructor Detail : " + tempInstructorDetail);

		// print the associated instructor

		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());


		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Deleting instructor id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Deleted Done!");

	}

	private void findInstructor(AppDAO appDAO) {

		int id = 2;
		System.out.println("Finding Instructor id: " + id);

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
