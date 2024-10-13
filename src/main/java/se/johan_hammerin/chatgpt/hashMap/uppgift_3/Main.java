package se.johan_hammerin.chatgpt.hashMap.uppgift_3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //HashMap
        HashMap<String, String> capitalCities = new HashMap<>();

        capitalCities.put("Sverige", "Stockholm");
        capitalCities.put("Frankrike", "Paris");
        capitalCities.put("Nederländerna", "Amsterdam");
        capitalCities.put("Sydafrika", "Johannesburg");
        //Skriver ut HashMap
        System.out.println(capitalCities);



        //Tar bort en post/entry
        capitalCities.remove("Nederländerna");


        //Skriver ut HashMap
        System.out.println(capitalCities);
    }
}
