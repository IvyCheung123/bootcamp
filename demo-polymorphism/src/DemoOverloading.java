public class DemoOverloading {
  // Purpose of Overloading (Static Polymorphism):
  // The design of overloading for methods is to allow user easier to use
  // Overloading is designed and checked during compile time

  private int a;
  private int b;

  public DemoOverloading() {
    // this.a = 100;
    // this.b = 100;
    // this(100, 100); // Calling DemoOverloading(int a, int b) constructor ...
    this(100.0, 100.0); // Calling DemoOverloading(double a, double b) constructor ...
  }

  public DemoOverloading(int a) {
    // this.a = a;
    // this.b = 100;
    this(a, 100.0); // Calling DemoOverloading(double a, double b) constructor ...
  }

  public DemoOverloading(int a, int b) {
    System.out.println("Calling DemoOverloading(int a, int b) constructor ...");
    this.a = a;
    this.b = b;
  }

  public DemoOverloading(double a, double b) {
    System.out.println("Calling DemoOverloading(double a, double b) constructor ...");
    this.a = (int) a;
    this.b = (int) b;
  }

  public static int sum(int x, int y) {
    return x + y;
  }

  public static double sum(double x, double y) {
    return x + y;
  }

  // Duplicate method sum(int, int) in type DemoOverloading
  // public static double sum(int x, int y) {
  //   return x + y;
  // }

  public static long sum(int x, long y) {
    return x + y;
  }

  public static long sum(long x, int y) {
    return x + y;
  }

  public static void sum(Object x, Object y) {
    System.out.println("Calling static void sum(Object x, Object y) ...");
  }

  public static void sum(Animal2 x, Animal2 y) {
    System.out.println("Calling static void sum(AnimalTwo x, AnimalTwo y) ...");
  }
  
  public static void main(String[] args) {
    // Example 1:
    String str1 = String.valueOf(true); // true
    String str2 = String.valueOf(2.0d); // 2.0
    char[] arr = new char[] {'a', 'b', 'c'};
    String str3 = String.valueOf(arr);
    System.out.println(str3); // abc

    // Example 2:
    System.out.println(DemoOverloading.sum(1, 2)); // 3
    System.out.println(DemoOverloading.sum(1.0d, 2.0d)); // 3.0

    // Find the nearest one for promotion
    System.out.println(DemoOverloading.sum((byte) 1, (short) 2)); // 3, byte + short -> int
    System.out.println(DemoOverloading.sum(10L, 12L)); // 22.0, long -> double

    sum("hello", "world"); // Calling static void sum(Object x, Object y) ...
    sum(new Cat2(), new Dog2()); // Calling static void sum(AnimalTwo x, AnimalTwo y) ...

    // Example 3:
    DemoOverloading do1 = new DemoOverloading();
    System.out.println(do1); // Calling DemoOverloading(double a, double b) constructor ...
    DemoOverloading do2 = new DemoOverloading(100);
    System.out.println(do2); // Calling DemoOverloading(double a, double b) constructor ...
    DemoOverloading do3 = new DemoOverloading(100, 100);
    System.out.println(do3); // Calling DemoOverloading(int a, int b) constructor ...
    DemoOverloading do4 = new DemoOverloading(100, 100.0);
    System.out.println(do4); // Calling DemoOverloading(double a, double b) constructor ...
    DemoOverloading do5 = new DemoOverloading(100.0, 100.0);
    System.out.println(do5); // Calling DemoOverloading(double a, double b) constructor ...

    // Casting Primitives
    int i = Integer.MAX_VALUE;
    System.out.println(i); // 2147483647
    long l = i + 1; // add two int (overflow of int) -> store to long
    System.out.println(l); // -2147483648
    long l2 = (long) i + 1; // upcast int to long -> add 1 and store to long
    System.out.println(l2); // 2147483648

    // What if the method parameters are with type of Wrapper Class?
    Integer i3 = Integer.MAX_VALUE;
    System.out.println(i3); // 2147483647
    Long l3 = i3 + 1L; // Type mismatch: cannot convert from int to Long
    System.out.println(l3); // 2147483648
    // Long l4 = (Long) i3 + 1L; // Cannot cast from Integer to Long
  }
}
