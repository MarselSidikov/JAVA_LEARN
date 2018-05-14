package demo;

public class RoosterRunnable implements Runnable {
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("Петух");
    }
  }
}
