package main.thread.ex.pgms;

import java.util.concurrent.atomic.AtomicInteger;

class CustomerThread extends Thread {

  private static AtomicInteger custId = new AtomicInteger(1);

  private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {

    protected Integer initialValue() {
      return custId.getAndIncrement();
    }
  };

  CustomerThread(final String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println("Thread " + Thread.currentThread().getName() + " started. Customer id is :" + tl.get());
  }
}

public class ThreadLocalEx2 {

  public static void main(String[] args) {
    CustomerThread t1 = new CustomerThread("Surendar");
    CustomerThread t2 = new CustomerThread("Vasugi");
    CustomerThread t3 = new CustomerThread("Vivek.B");
    CustomerThread t4 = new CustomerThread("Vivek.A");
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
