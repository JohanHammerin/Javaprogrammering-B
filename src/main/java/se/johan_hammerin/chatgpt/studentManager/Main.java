package se.johan_hammerin.chatgpt.studentManager;

public class Main {
    public static void main(String[] args) {
        //StudentManager
        StudentManager studentManager = new StudentManager();

        //Lägger till elever
        studentManager.addStudent(new Student("Adam",1));
        studentManager.addStudent(new Student("Bertil",2));
        studentManager.addStudent(new Student("Caesar",3));

        //Söker efter en elev
        studentManager.searchForStudent("Adam");

        //Skriver ut alla elever
        studentManager.printStudents();

        //Ta bort en elev
        studentManager.removeStudent("Caesar");

        //Skriver ut alla elever
        studentManager.printStudents();






    }
}
