package ru.itpark;

public class Main {

  public static void main(String[] args) {
    char a = 'A';
    int codeA = a;
    System.out.println(codeA);
    int codeB = 66;
    char b = (char)codeB;
    System.out.println(b);

    char text[] = "Hello, 123!".toCharArray();

    for (char c : text) {
      if ('A' <= c && c <= 'Z' ||
          'a' <= c && c <= 'z') {
        System.out.println(c + " - буква");
      } else if ('0' <= c && c <= '9') {
        System.out.println(c + " - цифра");
      } else {
        System.out.println(c + " - что-то другое");
      }
    }

    char c = 'x';

    System.out.println((char)(c + 'Z' - 'z'));
  }
}
