package object;

import java.util.Arrays;

public class Box {
  // static variable (belongs to class)
  private static String prefix = "Box";

  // instance variable (belongs to object)
  private String[] strs;
  private String name;

  /*
  public Box(String[] strs) {
    this.strs = strs;
  }
  */

  public Box() {
    this.strs = new String[0];
  }

  public void setName(String name) {
    this.name = Box.prefix.concat(".").concat(name);
  }

  public void setStrings(int index, String str) {
    this.strs[index] = str;
  }

  public void addStrings(String str) {
    String[] arr = new String[this.strs.length + 1];
    for (int i = 0; i < strs.length; i++) {
      arr[i] = this.strs[i];
    }
    arr[arr.length - 1] = str;
    this.strs = arr;
  }

  public void deleteString(String str) {
    // revise the arr length
    // remove corresponding Strings
    String[] arr = new String[this.strs.length];
    for (int i = 0; i < strs.length; i++) {
      arr[i] = this.strs[i];
    }
    this.strs = arr;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == str) {
        
      }
    }
  }

  public String getName() {
    return this.name;
  }

  public String[] getStrings() {
    return this.strs;
  }

  public String toString() {
    return Arrays.toString(this.strs);
  }

  public static void main(String[] args) {
    /*
    String[] strs1 = new String[] {"hello", "hello"};
    Box box1 = new Box(strs1);
    */
    Box box1 = new Box();
    box1.addStrings("hello");
    box1.addStrings("hello");
    // System.out.println(Arrays.toString(box.getStrings()));
    System.out.println(box1.toString()); // [hello, hello] (but has literal pool)

    box1.setStrings(1, "world");
    System.out.println(box1.toString()); // [hello, world]

    box1.deleteString("world");
    System.out.println(box1.toString());

    System.out.println(Box.prefix); // Box
    box1.setName("abc");
    System.out.println(box1.getName()); // Box.abc
  }
}
