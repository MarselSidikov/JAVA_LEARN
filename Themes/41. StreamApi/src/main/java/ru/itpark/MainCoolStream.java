package ru.itpark;

import java.util.Arrays;
import java.util.List;

public class MainCoolStream {
  public static void main(String[] args) {
    List<Integer> numbers =
        Arrays.asList(24,
            99,
            120,
            15);

    numbers.stream()
        .filter(number -> number % 2 == 0)
        .map(number -> {
          StringBuilder builder = new StringBuilder();
          while (number != 0) {
            int newDigit = number % 2;
            number = number / 2;
            builder.append(newDigit);
          }
          return builder.toString();
        }).forEach(System.out::println);
  }
}
