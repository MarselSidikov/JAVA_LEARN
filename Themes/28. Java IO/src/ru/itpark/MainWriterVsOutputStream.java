package ru.itpark;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MainWriterVsOutputStream {
  public static void main(String[] args) throws Exception {
    Writer writer =
        new OutputStreamWriter(new FileOutputStream("outputA.txt"));

    OutputStream outputStream = new FileOutputStream("outputB.txt");

    writer.write((int)'Я');
    outputStream.write((int)'Я');

    writer.close();
    outputStream.close();
  }
}
