package card;

import java.util.concurrent.locks.ReentrantLock;

public class Human extends Thread {

  // private final static Object lock = new Object();
  private final ReentrantLock lock = new ReentrantLock();
  private final BonusCard bonusCard;

  public Human(String name, BonusCard bonusCard) {
    super(name);
    this.bonusCard = bonusCard;
  }

  public void run() {
    for (int i = 0; i < 50; i++) {
      //synchronized (lock) {
      //lock.lock();
      lock.lock();
      if (bonusCard.getSum() > 0) {
        System.out.println(Thread.currentThread().getName() + " собрался купить");
        bonusCard.use(1);
        System.out.println(Thread.currentThread().getName() + " купил");
      } else {
        System.out.println(Thread.currentThread().getName() + " пошел домой");
        break;
      }
      lock.unlock();
    }
  }
}