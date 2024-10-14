package se.johan_hammerin.lektion_2;

public class TemperatureConverter {

    //Methods
    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double toFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }


}
