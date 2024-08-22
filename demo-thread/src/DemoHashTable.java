import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class DemoHashTable {
  public static void main(String[] args) {
    // HashMap: non thread-safe, better performance
    // Hashtable: thread-safe, poor performance (synchronized)
    HashMap<String, String> map = new HashMap<>();

    Runnable putEntryToHashMap1 = () -> {
      for (int i = 0; i < 100_000; i++) {
        map.put(String.valueOf(i), "hello");
      }
    };

    // i will repeat ... so ...
    Runnable putEntryToHashMap2 = () -> {
      for (int i = 100_000; i < 200_000; i++) {
        map.put(String.valueOf(i), "hello");
      }
    };

    long startTime = System.currentTimeMillis();
    Thread thread1 = new Thread(putEntryToHashMap1);
    Thread thread2 = new Thread(putEntryToHashMap2);

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
      long endTime = System.currentTimeMillis();
      System.out.println("HashMap runtime=" + (endTime - startTime)); // 84ms
      System.out.println("HashMap.size()=" + map.size()); // < 200_000
      // Steps to put entry in HashMap & HashSet
      // 1. Search
      // 2. Put
    } catch (InterruptedException e) {

    }

    Hashtable<String, String> table = new Hashtable<>();

    Runnable putEntryToHashtable1 = () -> {
      for (int i = 0; i < 100_000; i++) {
        table.put(String.valueOf(i), "hello");
      }
    };

    Runnable putEntryToHashtable2 = () -> {
      for (int i = 100_000; i < 200_000; i++) {
        table.put(String.valueOf(i), "hello");
      }
    };

    startTime = System.currentTimeMillis();
    Thread thread3 = new Thread(putEntryToHashtable1);
    Thread thread4 = new Thread(putEntryToHashtable2);

    thread3.start();
    thread4.start();

    try {
      thread3.join();
      thread4.join();
      long endTime = System.currentTimeMillis();
      System.out.println("Hashtable runtime=" + (endTime - startTime)); // 106ms
      System.out.println("Hashtable.size()=" + table.size()); // 200_000
    } catch (InterruptedException e) {

    }

    System.out.println("Program end");

    // null
    HashMap<Integer, String> map2 = new HashMap<>();
    map2.put(null, "abc");
    map2.put(2, null);
    System.out.println(map2.size()); // 2

    Hashtable<Integer, String> table2 = new Hashtable<>();
    // table2.put(null, "abc"); // NPE, key cannot be null
    // table2.put(2, null); // NPE, value cannot be null
    table2.put(1, "abc");
    table2.replace(1, "def");
    System.out.println(table2.get(1)); // def
    System.out.println(table2.size()); // 1
  }
}
