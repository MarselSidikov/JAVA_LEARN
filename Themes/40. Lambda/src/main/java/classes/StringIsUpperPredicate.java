package classes;

import java.util.function.Predicate;

public class StringIsUpperPredicate implements Predicate<String> {
  public boolean test(String s) {
    return Character.isUpperCase(s.charAt(0));
  }
}
