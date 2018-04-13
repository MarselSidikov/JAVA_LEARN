package ru.itpark.examples;

public class MainStackOverflow {
    static void f() {
        f();
    }
    public static void main(String[] args) {
        f();
    }
}
