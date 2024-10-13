package se.johan_hammerin.chatgpt.hashMap.uppgift_5;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //HashMap
        HashMap<String, String> capitalCities = new HashMap<>();

        capitalCities.put("Sverige", "Stockholm");
        capitalCities.put("Finland", "Helsingfors");
        capitalCities.put("Norge", "Oslo");

        for(String i: capitalCities.keySet()) {
            System.out.println("key:" + i + " value:" + capitalCities.get(i));
        }
    }
}
