package service;

public class ExecutorService {
  public void submit(Runnable task) {
    Thread newThread = new Thread(task);
    newThread.start();
  }
}
