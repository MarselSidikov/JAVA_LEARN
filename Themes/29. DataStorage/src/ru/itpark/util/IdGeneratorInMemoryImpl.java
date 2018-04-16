package ru.itpark.util;

public class IdGeneratorInMemoryImpl implements IdGenerator {
  private static IdGeneratorInMemoryImpl instance;

  static {
    instance = new IdGeneratorInMemoryImpl();
  }
  private IdGeneratorInMemoryImpl() {
    this.currentId = 0;
  }

  private int currentId;

  public static IdGenerator generator() {
    return instance;
  }

  @Override
  public int getNewId() {
    int lastId = currentId;
    currentId++;
    return lastId;
  }
}
