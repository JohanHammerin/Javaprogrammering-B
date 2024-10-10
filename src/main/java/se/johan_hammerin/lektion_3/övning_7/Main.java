package se.johan_hammerin.lektion_3.övning_7;

public class Main {
    public static void main(String[] args) {
        //Kursen
        Course javaprogrammering_A = new Course();
        //Elever
        Student johan = new Student("Johan","1");
        Student felix = new Student("Felix","2");
        Student håkan = new Student("Håkan","3");
        Student erik = new Student("Erik","4");
        Student linus = new Student("Linus","5");


        javaprogrammering_A.addStudent(johan);
        javaprogrammering_A.addStudent(felix);
        javaprogrammering_A.addStudent(håkan);
        javaprogrammering_A.addStudent(erik);
        javaprogrammering_A.addStudent(linus);

        javaprogrammering_A.printStudent("1");
        javaprogrammering_A.printStudent("2");
        javaprogrammering_A.printStudent("null");

    }
}
