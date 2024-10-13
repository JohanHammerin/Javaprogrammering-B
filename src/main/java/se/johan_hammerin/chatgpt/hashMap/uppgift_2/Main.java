package se.johan_hammerin.chatgpt.hashMap.uppgift_2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //HashMap
        HashMap<String, String> capitalCities = new HashMap<>();

        capitalCities.put("Sverige", "Stockholm");
        capitalCities.put("Danmark", "Köpenhamn");
        capitalCities.put("Norge", "Oslo");
        capitalCities.put("Finland", "Helsingfors");

        System.out.println(capitalCities.get("Norge"));
    }
}
