package ru.itpark.checked;

import java.text.ParseException;

public class Main {

  public static int parseWithParseException(String s) throws ParseException {
    char digits[] = s.toCharArray();
    int mult = 1;
    int result = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (Character.isDigit(digits[i])) {
        result += (digits[i] - '0') * mult;
        mult *= 10;
      } else {
          throw new ParseException("s", 0);
      }
    }
    return result;
  }

  public static int parseWithIllegalArgument(String s) {
    char digits[] = s.toCharArray();
    int mult = 1;
    int result = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (Character.isDigit(digits[i])) {
        result += (digits[i] - '0') * mult;
        mult *= 10;
      } else {
        throw new IllegalArgumentException();
      }
    }
    return result;
  }
  public static void main(String[] args) {
    //int x = parseWithIllegalArgument("12345a");

    try {
      int y = parseWithParseException("12345s");
      System.out.println(y);
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }

  }
}
