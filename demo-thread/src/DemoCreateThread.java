public class DemoCreateThread {
  public static void main(String[] args) { // main thread
    // Single Thread
    Integer x = 1;
    x++; // 2
    ++x; // 3

    // Multi Thread
    Task task1 = new Task();
    Thread thread1 = new Thread(task1); // thread1

    thread1.start(); // run()

    // By default without join(), main thread would proceed without waiting for thread1
    // Program end
    // i=0
    // i=1
    // i=2
    // i=3
    // i=4

    // But you can use join(), then both main thread and thread1 will wait each other
    // main thread is waiting for thread1 ...
    try {
      thread1.join();
    } catch (InterruptedException e) {

    }

    System.out.println("Program end");

    // i=0
    // i=1
    // i=2
    // i=3
    // i=4
    // Program end

    // Solution for multi thread
    // 1. Vector & Hashtable (refer to DemoVector.class & DemoHashtable.class)
    // 2. Create Thread as a class (refer to AddStringMSThread.class)
    AddStringMSThread thread2 = new AddStringMSThread();
    thread2.start(); // call run()
    try {
      thread2.join();
    } catch (InterruptedException e) {

    }
    System.out.println(thread2.getStrings().size()); // 1_000_000
  }
}
