package se.johan_hammerin.chatgpt.hashMap.uppgift_4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //HashMap
        HashMap<String, String> capitalCities = new HashMap<>();

        capitalCities.put("Sverige", "Stockholm");
        capitalCities.put("Finland", "Helsingfors");
        capitalCities.put("Norge", "Oslo");

        //Storlek på HashMap
        System.out.println(capitalCities.size());
    }
}
