package service;

public class Main {
  public static void main(String[] args) {
    ExecutorService service = new ExecutorService();
    DigitsTask digitsTask = new DigitsTask();
    service.submit(digitsTask);

    Runnable letterATask= () -> {
      for (int i = 0; i < 100; i++) {
        System.out.println('A');
      }
    };

    service.submit(letterATask);

    service.submit(() -> {
      for (int i = 0; i <100; i++) {
        System.out.println("");
      }
    });
  }
}
