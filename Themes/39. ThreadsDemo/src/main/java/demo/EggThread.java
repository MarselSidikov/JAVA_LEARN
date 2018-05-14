package demo;

public class EggThread extends Thread {
  // переопределяем метод run

  public EggThread() {
    super("Яйцо");
  }
  @Override
  public void run() {
    for (int i = 0; i < 100; i++ ) {
      System.out.println(Thread.currentThread().getName());
    }
  }
}
