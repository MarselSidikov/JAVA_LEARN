package ru.itpark;

public class Human {
  private String name;
  private int age;

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

//  public boolean equals(Human obj) {
//    return this.age == obj.age
//        && this.name == obj.name;
//  }

  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Human)) {
      return false;
    }
    if (this == obj) {
      return true;
    }

    Human that = (Human)obj;
    return this.age == that.age && this.name == that.name;
  }

  public String toString() {
    return name + " " + age;
  }
}
