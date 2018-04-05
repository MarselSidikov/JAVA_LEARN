package ru.itpark.fields;

public class Main {
    public static void main(String[] args) {

        System.out.println(SomeClass.staticField);

        SomeClass someObject = new SomeClass();
        someObject.staticField = 100;
        someObject.field = 10;

        SomeClass anotherObject = new SomeClass();
        anotherObject.staticField = 200;
        anotherObject.field = 15;

        SomeClass.staticField = 500;

        System.out.println(someObject.field);
        System.out.println(anotherObject.field);

        System.out.println("-------------");

        System.out.println(someObject.staticField);
        System.out.println(anotherObject.staticField);
    }
}
