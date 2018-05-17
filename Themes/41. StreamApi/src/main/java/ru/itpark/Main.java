package ru.itpark;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    List<Integer> numbers =
        Arrays.asList(24,
            99,
            120,
            15);

    Stream<Integer> numbersStream = numbers
        .stream();

    Stream<Integer> filteredStream =
        numbersStream.filter(number -> number % 2 == 0);

    Stream<String> binaryPresentedStream =
        filteredStream.map(number -> {
          StringBuilder builder = new StringBuilder();
          while (number != 0) {
            int newDigit = number % 2;
            number = number / 2;
            builder.append(newDigit);
          }
          return builder.toString();
        });

    binaryPresentedStream.forEach(binaryPresented -> System.out.println(binaryPresented));


  }
}
