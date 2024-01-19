package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//          deleteStudent(studentDAO);

//          deleteAllStudents(studentDAO);



		};
	}

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted rows count: " + numRowsDeleted);

    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 3;
        System.out.println("Deleting student with id: "+ studentId);
        studentDAO.delete(studentId);

    }

    private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Mohamed"
		System.out.println("Updated student ....");
		myStudent.setFirstName("Mohamed");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: "+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {


		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		// display list of students
		for (Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}

		// This is the same solution for above for each //
//		for (int i = 0; i < theStudents.size(); i++) {
//				Student tempStudent = theStudents.get(i);
//				System.out.println(tempStudent);
//
//		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students

		for (Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}


	}

	private void readStudent(StudentDAO studentDAO) {


		// create a student object
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		// save the student
		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary Key

		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		// display student

		System.out.println("Found the student: "+ myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ....");

		Student tempStudent1 = new Student("Mohamed", "Fathy",
				"mohamedfathy45@gmail.com");

		Student tempStudent2 = new Student("Ahmed", "Fathy",
				"ahmedfathy45@gmail.com");

		Student tempStudent3 = new Student("yousef", "Fathy",
				"youseffathy45@gmail.com");

		Student tempStudent4 = new Student("Amr", "Fathy",
				"amrfathy45@gmail.com");
		// save the student objects

		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);


	}

	private void createStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating new student object ....");

		Student tempStudent = new Student("Mohamed", "Fathy",
				"mohamedfathy45@gmail.com");

		// save the student object
		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());


	}
}












