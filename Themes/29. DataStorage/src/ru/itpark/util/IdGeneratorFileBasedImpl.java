package ru.itpark.util;

import java.io.*;
import java.util.Scanner;

public class IdGeneratorFileBasedImpl implements IdGenerator {

  private static IdGeneratorFileBasedImpl instance;

  static {
    instance = new IdGeneratorFileBasedImpl();
  }

  private int currentId;

  private IdGeneratorFileBasedImpl() {
    try {
      Scanner scanner = new Scanner(new File("user_id_value.txt"));
      currentId = scanner.nextInt();
    } catch (FileNotFoundException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public int getNewId() {
    try {
      Writer writer = new FileWriter("user_id_value.txt");
      currentId++;
      writer.write(String.valueOf(currentId));
      writer.close();
      return currentId;
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public static IdGenerator generator() {
    return instance;
  }
}
