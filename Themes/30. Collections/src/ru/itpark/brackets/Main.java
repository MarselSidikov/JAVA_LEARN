package ru.itpark.brackets;

import ru.itpark.ArrayList;
import ru.itpark.Stack;

public class Main {
  public static void main(String[] args) {
    char brackets[] = "()[()[{}{}<>]]".toCharArray();

    Stack stack = new ArrayList();

    // идем по всем скобкам
    for (int i = 0; i < brackets.length; i++) {
      // если текущая скобка открывающая
      if (isOpenBracket(brackets[i])) {
        // кладем в стек
        stack.push(brackets[i]);
      } else {
        // если скобка не открывающая, значит закрывающая
        // проверяем, не пуст ли стек, и если не пуст
        if (stack.size() != 0) {
          // берем последнюю скобку из стека
          char bracketFromStack = (char)stack.pop();
          // сравниваем на совместимость
          if (!isCompatible(bracketFromStack, brackets[i])) {
            System.out.println("1. Не верная последовательность");
            return;
          }
        } else {
          System.out.println("2. Не верная последовательность");
          return;
        }
      }
    }

    if (stack.size() != 0) {
      System.out.println("3. Не верная последовательность");
      return;
    }

    System.out.println("Все нормально");

  }

  private static boolean isCompatible(char open, char close) {
    return open == '(' && close == ')'
        || open == '<' && close == '>'
        || open == '{' && close == '}'
        || open == '[' && close == ']';
  }
  private static boolean isOpenBracket(char bracket) {
    return bracket == '('
        || bracket == '['
        || bracket == '<'
        || bracket == '{';
  }
}
