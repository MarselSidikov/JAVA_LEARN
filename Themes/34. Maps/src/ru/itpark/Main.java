package ru.itpark;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new MapByNodesArrayImpl<>();
        map.put("Марсель", 24);
        map.put("Артем", 29);
        map.put("Роман", 25);
        map.put("Настя", 19);
        map.put("Марсель", 25);

        System.out.println(map.get("Настя"));
        System.out.println(map.get("Марсель"));
        System.out.println(map.get("Роман"));

    }
}
