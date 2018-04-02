package ru.itpark;

public class Main {

    public static int fact(int n) {
        System.out.println("IN FACT n = " + n);
        if (n == 0) {
            return 1;
        }

        int result = fact(n - 1) * n;
        System.out.println("FROM FACT result = " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fact(6));
    }
}
