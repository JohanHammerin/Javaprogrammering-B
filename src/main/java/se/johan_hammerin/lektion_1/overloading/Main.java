package se.johan_hammerin.lektion_1.overloading;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(1,21));

        AccountManager accountManager = new AccountManager();
        accountManager.createAccount("Johan","password","johan@gmail.com");

    }
}
