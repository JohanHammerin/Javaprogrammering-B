package se.johan_hammerin.lektion_3.övning_7;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Course {
    //Attributes
    private String courseName;
    private List<Student> students = new ArrayList<>();


    //Methods
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Elev kan inte vara null.");
        }
        getStudents().add(student);
    }

    public void printStudent(String studentID) {
        for (Student s : getStudents()) {
            if (s.getStudentID().equals(studentID)) {
                System.out.println("Elev med ID:" + studentID + " namn: " + s.getName());
                return;
            }
        }
        System.out.println("Elev med ID " + studentID + " hittades inte.");

    }

    public void printStudents() {
        if (getStudents().isEmpty()) {
            System.out.println("Finns inga elever i denna kurs.");
        } else {
            for (Student student : getStudents()) {
                System.out.println(student);
            }
        }

    }


    //Getters & Setters
    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.isBlank()) {
            throw new InputMismatchException("Kursens namn kan inte vara tom eller null!");
        } else {
            this.courseName = courseName;
        }
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        if(students == null) {
            throw new IllegalArgumentException("Elever kan inte vara null");
        }
        this.students = students;
    }
}
