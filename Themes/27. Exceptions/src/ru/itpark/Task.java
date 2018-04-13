package ru.itpark;

public class Task {
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            try {
                throw new IllegalStateException();
            } catch (IllegalStateException x) {
                System.out.println("Privet");
            }
        } catch (IllegalStateException e) {
            System.out.println("Bye");
        }
    }
}
