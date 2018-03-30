package ru.itpark;

public class MainTask4 {
  public static void main(String[] args) {
    char text[] = "hello how are l you".toCharArray();
    int chars[] = new int[26];

    // chars[0] - количество букв а
    // chars[1] - количество букв b
    // chars[2] - количество букв c
    // ...
    // chars[25] - количество букв z

    for (int i = 0; i < text.length; i++) {
      // если не пробел
      if (text[i] != ' ') {
        // берем текущий символ и вычитаем
        // из него код буквы 'a'
        // 't' - 'a' = 116 - 97 = 19
        // char[19] - хранит количество букв t
        int charIndex = text[i] - 'a';
        chars[charIndex]++;
      }
    }
    // предполагаем, что буква 'a'
    // встречалась чаще всего
    int maxValue = chars[0];
    int letterIndex = 0;
    for (int i = 0; i < chars.length; i++) {
      // если нашли букву, которая встречалась чаще
      if (chars[i] > maxValue) {
        // запоминаем индекс
        letterIndex = i;
        maxValue = chars[i];
      }
    }

    System.out.println((char)(letterIndex + 'a'));

    int i = 0;
  }
}
