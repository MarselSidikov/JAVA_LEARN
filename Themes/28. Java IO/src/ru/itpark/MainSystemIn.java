package ru.itpark;

import java.io.IOException;
import java.io.InputStream;

public class MainSystemIn {

    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in;
            int value1 = inputStream.read();
            inputStream.read();
            System.out.println(value1);
            int value2 = inputStream.read();
            inputStream.read();
            System.out.println(value2);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
