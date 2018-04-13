package ru.itpark;

import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream("input.txt");
//        int byteFromInput = input.read();
//        while (byteFromInput != -1) {
//            System.out.println((char)byteFromInput);
//            byteFromInput = input.read();
//        }

        byte bytes[] = new byte[100];
        int size = input.read(bytes);
        for (int i = 0; i < size; i++) {
            System.out.println(bytes[i]);
        }
    }
}
