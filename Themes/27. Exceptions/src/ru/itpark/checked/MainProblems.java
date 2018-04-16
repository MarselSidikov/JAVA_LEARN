package ru.itpark.checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainProblems {
  public static void main(String[] args) {
    InputStream inputStream = null;
    try {
      inputStream = new FileInputStream("hello.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Что-то пошло не так");
    }

    // куча кода

    try {
      System.out.println(inputStream.read());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
