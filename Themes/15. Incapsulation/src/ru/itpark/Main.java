package ru.itpark;

import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        User users[] = new User[1000];

        Random random = new Random();

        for (int i = 0; i < users.length; i++) {
            users[i] = new User("User" + i,
                    random.nextInt(100));
        }

        int counts[] = new int[100];

        // users[752].age = -17;
        users[752] = new User("HAHA", -17);
        users[667].setAge(-17);

        for (int i = 0; i < users.length; i++) {
            counts[users[i].getAge()]++;
        }

        int maxAge = counts[0];
        for (int i = 0; i < counts.length; i++) {
            if (maxAge < counts[i]) {
                maxAge = i;
            }
        }

        System.out.println("Max age = " +  maxAge + " is " + counts[maxAge]);
       // System.out.println(users[0].name);
    }
}
