package se.johan_hammerin.lektion_2;

import junit.framework.TestCase;

public class TemperatureConverterTest extends TestCase {

    public void testToCelsius() {
        // Exempel på testfall
        assertEquals(0, TemperatureConverter.toCelsius(32.0), 0.01); // Konvertera 32°F till Celsius
        assertEquals(100.0, TemperatureConverter.toCelsius(212.0), 0.01); // Konvertera 212°F till Celsius
        assertEquals(-40.0, TemperatureConverter.toCelsius(-40.0), 0.01); // Konvertera -40°F till Celsius
    }

    public void testToFahrenheit() {
        // Exempel på testfall
        assertEquals(32.0, TemperatureConverter.toFahrenheit(0.0), 0.01); // Konvertera 0°C till Fahrenheit
        assertEquals(212.0, TemperatureConverter.toFahrenheit(100.0), 0.01); // Konvertera 100°C till Fahrenheit
        assertEquals(-40.0, TemperatureConverter.toFahrenheit(-40.0), 0.01); // Konvertera -40°C till Fahrenheit
    }
}
