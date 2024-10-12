package se.johan_hammerin.chatgpt.studentManager;

public class Student {

    //Attributes
    private String name;
    private int age;

    //Constructor
    public Student(String name, int age) {
        setName(name);
        setAge(age);
    }


    //Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString
    @Override
    public String toString() {
        return "Name:" + getName() + " Age:" + getAge();
    }
}
