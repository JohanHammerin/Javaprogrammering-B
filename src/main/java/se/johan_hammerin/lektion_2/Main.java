package se.johan_hammerin.lektion_2;

public class Main {
    public static void main(String[] args) {
        int multipliedNumbers = multiply(2,2);
        System.out.println(multipliedNumbers);


        MathConstants mathConstants = new MathConstants();
        System.out.println(mathConstants.addTen(10));


        System.out.println(Circle.getArea(10));



        Config.printConfig();


        System.out.printf("%.2f",TemperatureConverter.toCelsius(100));
    }

    private static int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}
