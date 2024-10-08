package se.johan_hammerin.lektion_2.calculator;

public class Config {
    //Constants
    public static final String APPLICATION_NAME = "Test.1";
    public static final String VERSION = "0.0.1";
    public static final int MAX_AMOUNT_OF_USERS = 10;

    //Method
    public static void printConfig() {
        System.out.println("APPLICATION_NAME: " + APPLICATION_NAME + "\n" +
                "VERSION: " + VERSION + "\n" +
                "MAX_AMOUNT_OF_USERS: " + MAX_AMOUNT_OF_USERS);
    }
}
