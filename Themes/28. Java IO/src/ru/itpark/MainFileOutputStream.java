package ru.itpark;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainFileOutputStream {
  public static void main(String[] args) {
    try {
      OutputStream output = new FileOutputStream("output.txt", true);
      String message = "Hello from Java!";
      byte[] bytes = message.getBytes();
      output.write(bytes);
      output.write((int)'S');
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

  }
}
