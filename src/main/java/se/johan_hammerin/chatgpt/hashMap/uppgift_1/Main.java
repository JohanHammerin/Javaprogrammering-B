package se.johan_hammerin.chatgpt.hashMap.uppgift_1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //HashMap
        HashMap<String, String> capitalCities = new HashMap<>();

        capitalCities.put("Sverige","Stockholm");
        capitalCities.put("Norge","Oslo");
        capitalCities.put("Danmark","Köpenhamn");
        capitalCities.put("Finland", "Helsingfors");

        //Skriver ut capitalCities
        System.out.println(capitalCities);
    }


}
