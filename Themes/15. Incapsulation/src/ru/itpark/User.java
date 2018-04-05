package ru.itpark;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;

        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeOlder(int age) {
        if (age >= 0) {
            this.age = this.age + age;
        }
    }
}
