import java.util.concurrent.atomic.AtomicInteger;

public class DemoIncrement {
  // Lock住越多房 run越慢 -> 一個thread入房做完出房 先到下一個thread
  private int x; // 0
  private int k; // 0

  // Solution 2: Atomic Type (原子性 不被入侵)
  private AtomicInteger y = new AtomicInteger(0); // only lock Integer value ...

  // Solution 3: DeadLock
  private final Object lock = new Object();

  // Soultion 1: synchronized method (more common)
  // instance method inside this object
  public synchronized void increment1() {
    // lines of code ...
    this.x++;
  }

  // Solution 3: DeadLock
  public void increment3() {
    this.k++; // multi thread may access variable k for read/write
    int x = 0; // object will store until local block ends -> auto disappear
    // 如果有兩個variables需要互相等待 risk ... 有機會行唔完
    synchronized (lock) { // locked a code block
      // lines of code ...
      this.x++;
    }
  }

  public static void main(String[] args) {
    DemoIncrement ball = new DemoIncrement();

    Runnable task = () -> {
      Thread threadInfo = Thread.currentThread(); // call current thread, not new thread
      System.out.println(threadInfo.getId());
      System.out.println(threadInfo.getName());
      // 13
      // Thread-0
      // 14
      // Thread-1

      for (int i = 0; i < 1_000_000; i++) {
        ball.x++; // by default, x++ support multi thread
        // ball (obj ref) -> multi thread access same obj memory address
      }
    };

    Thread thread0 = new Thread(task);
    Thread thread1 = new Thread(task);

    thread0.start();
    thread1.start();

    try {
      thread0.join();
      thread1.join();
    } catch (InterruptedException e) {

    }

    System.out.println("x=" + ball.x);

    // Solution 1: synchronized method
    ball.x = 0;

    Runnable task1 = () -> {
      Thread threadInfo1 = Thread.currentThread();
      System.out.println(threadInfo1.getId());
      System.out.println(threadInfo1.getName());
      // 15
      // Thread-2
      // 16
      // Thread-3
      // if (threadInfo1.getName().equals("Thread-2")) {
      //   // different flow in Thread-2 and Thread-3 ...
      // }

      for (int i = 0; i < 1_000_000; i++) {
        ball.increment1();
      }
    };

    Thread thread2 = new Thread(task1);
    Thread thread3 = new Thread(task1);

    thread2.start();
    thread3.start();

    try {
      thread2.join();
      thread3.join();
    } catch (InterruptedException e) {

    }

    System.out.println("x=" + ball.x); // x=2_000_000

    // Soultion 2: Atomic Type (原子性 不被入侵)
    ball.x = 0;

    Runnable task2 = () -> {
      Thread threadInfo2 = Thread.currentThread();
      System.out.println(threadInfo2.getId());
      System.out.println(threadInfo2.getName());
      // 17
      // Thread-4
      // 18
      // Thread-5

      for (int i = 0; i < 1_000_000; i++) {
        ball.y.incrementAndGet(); // similar to y++, revise itself, thread-safe
      }
    };

    Thread thread4 = new Thread(task2);
    Thread thread5 = new Thread(task2);

    thread4.start();
    thread5.start();

    try {
      thread4.join();
      thread5.join();
    } catch (InterruptedException e) {

    }

    System.out.println("y=" + ball.y.get()); // x=2_000_000

    // Soultion 3: DeadLock
    ball.x = 0;

    Runnable task3 = () -> {
      Thread threadInfo3 = Thread.currentThread();
      System.out.println(threadInfo3.getId());
      System.out.println(threadInfo3.getName());
      // 19
      // Thread-6
      // 20
      // Thread-7

      for (int i = 0; i < 1_000_000; i++) {
        ball.increment3();
      }
    };

    Thread thread6 = new Thread(task3);
    Thread thread7 = new Thread(task3);

    thread6.start();
    thread7.start();

    try {
      thread6.join();
      thread7.join();
    } catch (InterruptedException e) {

    }

    System.out.println("k=" + ball.k); // k=1999652
    System.out.println("x=" + ball.x); // x=2000000

    System.out.println("Program end");
  }
}
