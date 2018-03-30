package ru.itpark;

import java.util.Scanner;

public class Main {

    public static int sumDigits(int number) {
        int result = 0;
        while (number != 0) {
            result = result + number % 10;
            number = number / 10;
        }
        return result;
    }
    // получить сумму цифр числа через функцию

    public static int sum(int a, int b) {
        int result = 0;
        for (int i = a; i <= b; i++) {
            result = result + i;
        }
        return result;
    }


    public static boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        } else {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        boolean result = isPrime(number);
        if (result == true) {
            System.out.println("Простое");
        } else {
            System.out.println("Составное");
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int s = sum(a, b);
        System.out.println(s);
        System.out.println(sumDigits(123));
    }
}
