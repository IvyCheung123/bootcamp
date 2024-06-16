package object;

import java.math.BigDecimal;

public class Calculator {
  private int x;
  private int y;

  // Static method -> Instance method
  public static int sum(int x, int y) {
    System.out.println("static method sum(int x, int y) is running ...");
    return x + y;
  }

  public static double sum(double x, double y) {
    System.out.println("static method sum(double x, double y) is running ...");
    return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).doubleValue();
  }

  public static double sum(float x, double y) {
    System.out.println("static method sum(float x, double y) is running ...");
    return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).doubleValue();
  }

  // Instance method
  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }
  
  public int sum() { // 唔會撞名 -> sum() != sum(int x, int y)
    System.out.println("instance method sum(int x, int y) is running ...");
    return this.x + this.y;
  }
  public int multiply() {
    System.out.println("instance method multiply(int x, int y) is running ...");
    return this.x * this.y;
  }

  // testing
  public static void test1(String[] args) {
    for (int i = 0; i < args.length; i++) {
      System.out.println(args[i]);
    }
  }

  public static void test2(String... args) { // String... and String[] are same type
    // for-each
    for (String s : args) {
      System.out.println(s);
    }
  }

  public static void main(String[] args) {
    System.out.println(sum(1, 3)); // 4
    System.out.println(Calculator.sum(2, 4)); // 6

    Calculator c1 = new Calculator();

    c1.setX(2);
    c1.setY(3);

    System.out.println(c1.sum()); // 2 + 3 = 5
    System.out.println(c1.multiply()); // 2 * 3 = 6

    // Method overloading: same name, automatically find different data type
    System.out.println(sum(1, 2)); // sum(int x, int y) is running ...
    System.out.println(sum(1.0, 2.0)); // sum(double x, double y) is running ...
    System.out.println(sum(1.0f, 2.0f)); // sum(float x, double y) is running ...
    // String.valueOf() -> overloading
    System.out.println(String.valueOf(10L)); // 10
    System.out.println(String.valueOf(new char[] {'a', 'b', 'c'})); // abc

    Calculator.test1(new String[] {"hello", "world"});
    Calculator.test2(new String[] {"hello", "world"});
    Calculator.test2("hello", "world");

    System.out.println(Calculator.sum(3, 2)); // 5, call static method
    Calculator c2 = new Calculator();
    c2.setX(3); // instance method
    c2.setY(2); // instance method
    System.out.println(c2.sum()); // 5, call instance method

    System.out.println(c2.sum(3, 2)); // 5, call static method

    // Conclusion:
    // Static method can be called by instance (object) or Class name
    // Instance method can be called by instance (object) only
  }
}
