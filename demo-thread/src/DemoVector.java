import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DemoVector {
  public static void main(String[] args) {
    // ArrayList: non thread-safe, better performance
    // Vector: thread-safe, poor performance (synchronized)
    List<String> strings1 = new ArrayList<>();

    Runnable addStringToArrayList = () -> {
      for (int i = 0; i < 1_000_000; i++) {
        strings1.add("hello");
      }
      // System.out.println("ArrayList.size()=" + strings.size()); // 1_000_000
    }; // run() method implementation

    long startTime = System.currentTimeMillis();
    Thread thread1 = new Thread(addStringToArrayList);
    Thread thread2 = new Thread(addStringToArrayList);

    thread1.start(); // call run()
    thread2.start();

    try {
      thread1.join();
      thread2.join();
      long endTime = System.currentTimeMillis();
      System.out.println("ArrayList runtime=" + (endTime - startTime)); // 47ms
      System.out.println("ArrayList.size()=" + strings1.size()); // < 2_000_000 or run-time error
      // ArrayIndexOutOfBoundsException: Index 134042 out of bounds for length 106710
      // Steps to add element in ArrayList (Underlying DS: Array)
      // 1. Create a new Array (old Array lenght + 1)
      // 2. Copy old Array to new Array
      // 3. Add new element to Array
      // 4. Reassign new obj ref to old obj ref
    } catch (InterruptedException e) {

    }

    List<String> strings2 = new Vector<>(); // different implementation -> has synchronized method

    Runnable addStringToVector = () -> {
      for (int i = 0; i < 1_000_000; i++) {
        strings2.add("hello");
      }
    }; // run() method implementation

    startTime = System.currentTimeMillis();
    Thread thread3 = new Thread(addStringToVector);
    Thread thread4 = new Thread(addStringToVector);

    thread3.start(); // call run()
    thread4.start();

    try {
      thread3.join();
      thread4.join();
      long endTime = System.currentTimeMillis();
      System.out.println("Vector runtime=" + (endTime - startTime)); // 108ms
      System.out.println("Vector.size()=" + strings2.size()); // 2_000_000
    } catch (InterruptedException e) {

    }

    // System.out.println(strings.size()); // 0 -> main() flow

    System.out.println("Program end");
  }
}
