package ru.itpark;

public class Human implements Comparable<Human> {
  private String name;
  private int age;
  private int height;

  public Human(String name, int age, int height) {
    this.name = name;
    this.age = age;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public int compareTo(Human o) {
    return this.age - o.age;
  }

  @Override
  public String toString() {
    return "Human{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", height=" + height +
        '}';
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
