package ru.itpark.simple;

import ru.itpark.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Simple", 17);
        System.out.println(user.getAge());
        // System.out.println(user.name);
    }
}
