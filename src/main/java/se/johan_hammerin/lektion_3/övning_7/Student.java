package se.johan_hammerin.lektion_3.övning_7;

import java.util.InputMismatchException;

public class Student {
    //Attributes
    private String name;
    private String studentID;

    //Constructor
    public Student(String name, String studentID) {
        setName(name);
        setStudentID(studentID);
    }

    //Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new InputMismatchException("Namn kan inte vara tomm eller null!");
        } else {
            this.name = name;
        }
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        if (studentID == null || studentID.isBlank()) {
            throw new InputMismatchException("ID kan inte vara tomm eller null!");
        } else {
            this.studentID = studentID;
        }
    }

    //toString
    @Override
    public String toString() {
        return "Name:" + getName() + "\n" +
                "studentID:" + getStudentID();

    }
}
