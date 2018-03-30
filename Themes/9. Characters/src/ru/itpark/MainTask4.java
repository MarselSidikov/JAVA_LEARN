package ru.itpark;

public class MainTask4 {
  public static void main(String[] args) {
    char text[] = "hello how are l you".toCharArray();
    int chars[] = new int[27];

    // chars[0] - количество букв а
    // chars[1] - количество букв b
    // chars[2] - колиечтво c

    for (int i = 0; i < text.length; i++) {
      if (text[i] != ' ') {
        int charIndex = text[i] - 'a';
        chars[charIndex]++;
      }
    }

    int maxValue = chars[0];
    int letterIndex = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] > maxValue) {
        letterIndex = i;
        maxValue = chars[i];
      }
    }

    System.out.println((char)(letterIndex + 'a'));

    int i = 0;
  }
}
