import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// вспомогательный класс
// который выполняет какие-либо преобразования со
// строками
// при этом сам класс не знает, какие именно
// преобразования возможны
public class StringUtil {

  // статическая функциоя преобразованя списка строк
  // string в список других объектов
  // по определенному правилу
  // Function<String, R> function - метод принимает
  // объект, класс которого реализует интерфейс Function
  // таким образом, что его метод apply принимает на вход
  // строку, а на выход - объект типа R
  public static <R> List<R> map(List<String> strings,
                                Function<String, R> function) {
    // создаем новый список, но уже типа R
    List<R> result = new ArrayList<>();
    // для каждой строки
    for (String string : strings) {
      // создаем новый объект из строки
      // по какому-либо правилу
      R newObject = function.apply(string);
      // кладем этот объект в результат
      result.add(newObject);
    }
    return result;
  }

  // статическая функция, которая принимает на вход
  // список строк, а также объект Predicate
  public static List<String> filter(List<String> strings,
                                    Predicate<String> predicate) {
    // создается новый список
    List<String> result = new ArrayList<>();
    // пробегаем все элементы исходного списка
    for (String string : strings) {
      // если метод test вернул true для данной строки
      // то добавляем ее в новый список
      if (predicate.test(string)) {
        result.add(string);
      }
    }

    return result;
  }

  public static void forEach(List<String> strings,
                             Consumer<String> consumer) {
    for (String string : strings) {
      consumer.accept(string);
    }
  }
}
