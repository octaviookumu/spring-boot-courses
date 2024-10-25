package com.octaviookumu.cruddemo;

import com.octaviookumu.cruddemo.dao.StudentDAO;
import com.octaviookumu.cruddemo.entity.Student;
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


    @Bean // executed after spring beans have been loaded
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            //  createStudent(studentDAO);

               createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            // deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on id: primary key
        Student myStudent = studentDAO.findById(2);

        // change first name to scooby
        System.out.println("Updating student ...");
        myStudent.setLastName("Grey");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get list of students
        List<Student> theStudents = studentDAO.findByLastName("Nuts");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Deez", "Nuts", "deez@yahoo.com");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of saved student
        int studentId = tempStudent.getId();
        System.out.println("Retrieving student with id: " + studentId);


        // retrieve student based on id: primary key
        Student myStudent = studentDAO.findById(studentId);

        // display student
        System.out.println("Found student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("Cyclops", "Mutant", "cyclops@gmail.com");
        Student tempStudent2 = new Student("Rogue", "Mutant", "rogue@gmail.com");
        Student tempStudent3 = new Student("Nightcrawler", "Mutant", "crawler@gmail.com");

        // saving student objects
        System.out.println("Saving the students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Gotha", "Omgothest", "gotha@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

    }

}
