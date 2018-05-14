package demo;

public class Main {
  public static void main(String[] args) {
    // в объектную переменную
    // класса Thread положили экземпляр
    // текущего потока
    Thread main = Thread.currentThread();
    System.out.println(main.getName());

    try {
      Thread.sleep(3000);
      System.out.println("After sleep");
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }


  }
}
