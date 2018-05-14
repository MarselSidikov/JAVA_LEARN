import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringUtil {

  public static <R> List<R> convert(List<String> strings, Function<String, R> function) {
    List<R> result = new ArrayList<>();
    for (String string : strings) {
      result.add(function.apply(string));
    }
    return result;
  }

  public static List<String> filter(List<String> strings, Predicate<String> predicate) {
    List<String> result = new ArrayList<>();

    for (String string : strings) {
      if (predicate.test(string)) {
        result.add(string);
      }
    }

    return result;
  }
}
