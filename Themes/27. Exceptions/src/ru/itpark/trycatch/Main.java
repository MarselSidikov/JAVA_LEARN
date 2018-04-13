package ru.itpark.trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;

        while (true) {
            try {

                a = scanner.nextInt();

                if (a % 2 == 1) {
                    throw new IllegalArgumentException("Можно только четные!");
                }

                b = scanner.nextInt();
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                System.out.println("Делить на ноль нельзя, потому что " + e.getMessage());
                throw new IllegalArgumentException(e);
            } catch (InputMismatchException e) {
                System.out.println("Мы ожидаем число!");
                System.out.println(e.getMessage());
                scanner.next();
            }
        }
    }
    public static void main(String[] args) {
        run();
    }
}

