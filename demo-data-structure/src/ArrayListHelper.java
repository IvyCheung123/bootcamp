import java.util.Arrays;

public class ArrayListHelper {

  private Integer[] integers;

  public ArrayListHelper() {
    this.integers = new Integer[0];
  }

  public void add(Integer i) {
    Integer[] arr = new Integer[this.integers.length + 1];
    int idx = 0;
    for (Integer x : this.integers) {
      arr[idx++] = x;
    }
    arr[idx] = i;
    this.integers = arr;
  }

  public void remove(int index) {
    // [2, 10, -4, 100] -> remove 100 -> [0, 1, 2]
    Integer[] arr = new Integer[this.integers.length - 1]; // [0, 1, 2]
    int idx = 0;
    for (int i = 0; i < this.integers.length; i++) { // [0, 1, 2, 3]
      if (i != index) {
        arr[idx++] = this.integers[i];
      }
    }
    this.integers = arr;
  }

  public Integer[] getIntegers() {
    return this.integers;
  }

  public int size() {
    return this.integers.length;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.integers);
  }

  public static void main(String[] args) {
    ArrayListHelper list = new ArrayListHelper();
    list.add(2);
    list.add(10);
    list.add(-4);

    for (Integer x : list.getIntegers()) {
      System.out.println(x);
    }
    System.out.println(list); // [2, 10, -4]

    list.add(100);
    System.out.println(list); // [2, 10, -4, 100]

    list.remove(3);
    System.out.println(list); // [2, 10, -4]
  }
}
