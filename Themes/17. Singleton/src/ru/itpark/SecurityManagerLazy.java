package ru.itpark;

public class SecurityManagerLazy {
    private static SecurityManagerLazy instance;

    public static SecurityManagerLazy getManager() {
        if (instance == null) {
            instance = new SecurityManagerLazy();
        }
        return instance;
    }

    private String names;

    // приватный конструктор - запретили создавать
    // объекты снаружи
    private SecurityManagerLazy() {
        this.names = "Names: ";
    }

    public void addName(String name) {
        this.names += name + " ";
    }

    public void print() {
        System.out.println(names);
    }
}
