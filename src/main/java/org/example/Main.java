package org.example;

public class Main {
    public static void main(String[] args) {

        HashMapPractice.HashMap<String , Integer> map = new HashMapPractice.HashMap<>();
        map.put("India", 190);
        map.put("China", 160);
        map.put("Indonesia", 12);

        System.out.println(map.containsKey("pakistan"));
        System.out.println(map.get("India"));
        System.out.println(map.remove("China"));
    }
}