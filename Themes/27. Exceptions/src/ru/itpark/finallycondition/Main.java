package ru.itpark.finallycondition;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException();
        } catch (IllegalStateException e) {
            System.out.println("Bye");
        } finally {
            System.out.println("Always");
        }
    }
}
