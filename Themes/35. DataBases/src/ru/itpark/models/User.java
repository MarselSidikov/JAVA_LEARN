package ru.itpark.models;

public class User {
  private Integer id;
  private String name;
  private Integer age;
  private Double height;

  private User(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.age = builder.age;
    this.height = builder.height;
  }

  public static class Builder {
    private Integer id;
    private String name;
    private Integer age;
    private Double height;

    public Builder id(Integer id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder age(Integer age) {
      this.age = age;
      return this;
    }

    public Builder height(Double height) {
      this.height = height;
      return this;
    }

    public User build() {
      return new User(this);
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", height=" + height +
        '}';
  }
}
