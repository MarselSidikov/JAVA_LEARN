package ru.itpark;

public class Main {

    public static void main(String[] args) {
        String s = "1234";
        int i = Integer.parseInt(s);
        System.out.println(i + 1);

        char c = 'A';
        char c1 = '1';
        char c2 = 'a';

        System.out.println(Character.isDigit(c));
        System.out.println(Character.isDigit(c1));
        System.out.println(Character.isLowerCase(c2));
        System.out.println(Character.isLowerCase(c));

        MyInteger myInteger = MyInteger.valueOf(4);
    }
}
