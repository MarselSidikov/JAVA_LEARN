package ru.itpark;

public class MainOutOfMemory {
    public static void main(String[] args) {
        String strings[] = new String[Integer.MAX_VALUE - 1000];
    }
}
