package ru.itpark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFileInputStream {
    public static void main(String[] args) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("input.txt");
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
//        int byteFromInput = input.read();
//        while (byteFromInput != -1) {
//            System.out.println((char)byteFromInput);
//            byteFromInput = input.read();
//        }

        byte bytes[] = new byte[100];
        int size = 0;
        try {
            size = input.read(bytes);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(bytes[i]);
        }
    }
}
