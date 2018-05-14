import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
//    StringIsUpperPredicate predicate = new StringIsUpperPredicate();
//    System.out.println(predicate.test("Hello"));
//    System.out.println(predicate.test("bye"));

    // анонимный класс
    Predicate<String> predicate = new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return Character.isUpperCase(s.charAt(0));
      }
    };

    Predicate<String> predicateLambda = string ->
        Character.isUpperCase(string.charAt(0));

    List<String> strings = new ArrayList<>();
    strings.add("Hello");
    strings.add("hello");
    strings.add("Bello");
    strings.add("23ello");
    strings.add("Marsel");

    List<String> filtered = StringUtil.filter(strings,
        string -> Character.isUpperCase(string.charAt(0)));
    System.out.println(filtered);

    filtered = StringUtil.filter(strings,
        string -> Character.isDigit(string.charAt(0)));
    System.out.println(filtered);

    Function<String, Integer> stringLenghFunction = new Function<String, Integer>() {
      @Override
      public Integer apply(String s) {
        return s.length();
      }
    };

    List<Integer> legnths =
        StringUtil.convert(strings,
            string -> string.length());
    System.out.println(legnths);

    List<Character> firstChars =
        StringUtil.convert(strings,
            string -> string.charAt(0));
    System.out.println(firstChars);

  }
}
