/*
TASK - 5 java development internship Codsoft
STUDENT COURSE REGISTRATION SYSTEM

1) Course Database: Store course information, including course code, title,
   description, capacity, and schedule.
2) Student Database: Store student information, including student ID, name, and
   registered courses.
3) Course Listing: Display available courses with details and available slots.
   Student Registration: Allow students to register for courses from the available
   options.
4) Course Removal: Enable students to drop courses they have registered for.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



// main class representing the course registration system
public class StudentCourse{
    public static void main(String[] args) {
        System.out.println("### STUDENT COURSE REGISTRATION SYSTEM ###");

        // Sample courses
        Course mathCourse = new Course("MATH01", "Introduction to Mathematics", "Basic math concepts", 30, "Mon/Wed 9:00 AM");
        Course biCourse = new Course("BI0201", "Biology Fundamentals", "Introduction to biology", 25, "Tue/Thu 2:00 PM");

        // Sample Students
        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Jane Doe");

        // Course Registration
        student1.registeCourses(mathCourse);
        student1.registeCourses(biCourse);

        student2.registeCourses(biCourse);


        // Displaying Registered Courses for Students
        System.out.println("\n" + student1.name + "'s Registered Courses:");
        for(Course course : student1.registeCourses) {
            System.out.println(course.title);
        }

        System.out.println("\n" + student2.name + "'s Registered Courses:");
        for(Course course : student2.registeCourses){
            System.out.println(course.title);
        }

        // Course Removal
        student1.removeCourse(mathCourse);
        student2.removeCourse(biCourse);

        // Displaying Registered Courses after removal
        System.out.println("\nAfter Course Reoval:");
        for(Course course : student1.registeCourses) {
            System.out.println(student1.name + ": " + course.title);
        }

        for(Course course : student2.registeCourses) {
            System.out.println(student2.name + ": " + course.title);
        }

    }
}


// Represents a Courses with relevant details
class Course{
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    // Constructor to initialize course details
    public Course(String code, String title, String description, int capacity, String schedule){
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

// Represents a Student with relevant details & method for registration
class Student {
    int id;
    String name;
    List<Course> registeCourses;

    // Constructor to initialize student details 
    public Student(int id, String name){
        this.id = id;
        this.name = name;
        this.registeCourses = new ArrayList<>();
    }

    // Method for a student to register for a course
    public void registeCourses(Course course){
        if(course.capacity > 0){
            registeCourses.add(course);
            course.capacity--;
            System.out.println(name + " registered for course: " + course.title);
        } else {
            System.out.println("Course " + course.title + " is full. Cannot register.");
        }
    }

    // Method for a student to remove a course
    public void removeCourse(Course course){
        if(registeCourses.contains(course)) { 
            registeCourses.remove(course);
            course.capacity++;
            System.out.println(name + " dropped course: " + course.title);
        } else {
            System.out.println(name + " is not registered for course: " + course.title);
        }
    }
  }
