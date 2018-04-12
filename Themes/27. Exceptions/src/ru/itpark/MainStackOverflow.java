package ru.itpark;

public class MainStackOverflow {
    static void f() {
        f();
    }
    public static void main(String[] args) {
        f();
    }
}
