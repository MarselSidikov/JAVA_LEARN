package ru.itpark;

import java.io.InputStream;

public class MainSystemIn {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int value1 = inputStream.read();
        inputStream.read();
        System.out.println(value1);
        int value2 = inputStream.read();
        inputStream.read();
        System.out.println(value2);
    }
}
