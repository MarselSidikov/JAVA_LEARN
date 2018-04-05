package ru.itpark.fields;

public class SomeClass {
    int field;
    static int staticField;

    static {
        staticField = 999;
    }

    void someMethod() {
        System.out.println(staticField);
    }

    static void staticMethod() {
        // System.out.println(field);
        System.out.println(staticField);
    }
}
