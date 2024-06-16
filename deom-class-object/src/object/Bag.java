package object;

import java.util.Arrays;

public class Bag {
  private int[] integers;

  public Bag() {

  }

  public Bag(int[] integers) {
    this.integers = integers;
  }

  public void setIntegers(int[] integers) {
    this.integers = integers;
  }

  public int[] getIntegers() {
    return this.integers;
  }

  public String toString() {
    return "Integers: " + Arrays.toString(this.integers);
  }

  public static void main(String[] args) {
    System.out.println(new Bag(new int[] {10, 20, 30}).toString()); // no object reference

    Bag b1 = new Bag(new int[] {100, 200, 300}); // no int[] object reference
    System.out.println(b1.toString());

    int[] arr2 = new int[] {1, 2, 3}; // int[] object (object reference arr2)
    Bag b2 = new Bag(arr2); // Bag object (object reference b2)
    System.out.println(b2.toString());
    b2.setIntegers(new int[] {11, 22, 33}); // no int[] object reference
    System.out.println(b2.toString());

    b1 = new Bag(arr2);
    System.out.println(b1.toString());

    Bag b3 = new Bag(arr2);
    // Bag class is public class
    // Bag() is public constructor
    b3.setIntegers(arr2); // setIntegers() is public method
  }
}
