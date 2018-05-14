package demo;

public class MainEggVersusChicken {
  public static void main(String[] args) {
    EggThread eggThread = new EggThread();
    ChickenThread chickenThread = new ChickenThread();
    RoosterRunnable roosterRunnable = new RoosterRunnable();
    Thread roosterThread = new Thread(roosterRunnable);
    // для того, чтобы запустить поток
    // нужно использовать


    eggThread.start();
    chickenThread.start();
    roosterThread.start();

    try {
      eggThread.join(); // x.join()
      chickenThread.join(); // y.join()
      roosterThread.join(); // z.join()
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }

    for (int i = 0; i < 100; i++) {
      System.out.println("Динозавр");
    }

//    try {
//      Thread.currentThread().join();
//    } catch (InterruptedException e) {
//      throw new IllegalStateException(e);
//    }
  }
}
