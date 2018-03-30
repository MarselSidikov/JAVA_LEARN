package ru.itpark;

import java.util.Scanner;

public class Main {

    static int count = 0;

    public static void addLine(String lines[], String line) {
        lines[count] = line;
        count++;
    }


    public static void main(String[] args) {
        String lines[] = new String[5];

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            addLine(lines, line);
        }

    }
}
