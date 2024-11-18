import java.util.*;
import java.util.Scanner;
class Course {
    String courseId;
    String courseName;

    Course(String id, String name) {
        this.courseId = id;
        this.courseName = name;
    }

    @Override
    public String toString() {
        return courseId + ": " + courseName;
    }
}

class Student {
    String studentId;
    String studentName;
    List<Course> registeredCourses;

    Student(String id, String name) {
        this.studentId = id;
        this.studentName = name;
        this.registeredCourses = new ArrayList<>();
    }

    void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    void displayRegisteredCourses() {
        System.out.println("Registered Courses for " + studentName + ":");
        for (Course course : registeredCourses) {
            System.out.println(course);
        }
    }
}

public class RegistrationSystem 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course math = new Course("MATH101", "Mathematics");
        Course english = new Course("ENG101", "English");
        Course science = new Course("SCI101", "Science");

        Student student = new Student("S001", "John Doe");

        System.out.println("Registering courses...");
        student.registerCourse(math);
        student.registerCourse(english);
        student.registerCourse(science);

        student.displayRegisteredCourses();
    }
}


