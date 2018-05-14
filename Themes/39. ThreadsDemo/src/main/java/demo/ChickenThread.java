package demo;

public class ChickenThread extends Thread {
  public ChickenThread() {
    super("Курица");
  }

  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName());
    }
  }
}
