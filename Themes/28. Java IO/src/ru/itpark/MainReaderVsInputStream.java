package ru.itpark;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainReaderVsInputStream {
  public static void main(String[] args) throws Exception {
    Reader reader =
        new InputStreamReader(
            new FileInputStream("input.txt"));
    int fromFileByReader = reader.read();
    System.out.println(fromFileByReader);

    InputStream inputStream =
        new FileInputStream("input.txt");
    int fromFileByInputStream = inputStream.read();
    System.out.println(fromFileByInputStream);
  }
}
