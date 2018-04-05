package ru.itpark;

public class SecurityManager {
    // статическая переменная, которая будет хранить
    // единственный экземпляр класса
    private static SecurityManager instance;

    static {
        instance = new SecurityManager();
    }

    public static SecurityManager getManager() {
        return instance;
    }

    private String names;

    // приватный конструктор - запретили создавать
    // объекты снаружи
    private SecurityManager() {
        this.names = "Names: ";
    }

    public void addName(String name) {
        this.names += name + " ";
    }

    public void print() {
        System.out.println(names);
    }
}
