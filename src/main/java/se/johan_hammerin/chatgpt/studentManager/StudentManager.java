package se.johan_hammerin.chatgpt.studentManager;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class StudentManager {
    //Attribute
    private List<Student> students;

    //Constructor
    public StudentManager() {
        this.students = new ArrayList<>();
        //this.students = new LinkedList<>();
    }

    //Methods
    public void addStudent(Student student) {
        getStudents().add(student);
    }

    public void removeStudent(String name) {
        for(Student student: getStudents()) {
            if(student.getName().equals(name)) {
                getStudents().remove(student);
                return;
            }
        }
    }

    public void searchForStudent(String name) {
        for (Student student : getStudents()) {
            if (student.getName().equals(name)) {
                System.out.println(name + " är en elev");
                return;
            }
        }
        System.out.println(name + " är inte en elev");
    }

    public void printStudents() {
        System.out.println(getStudents());
    }

    //Getter & Setter
    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
