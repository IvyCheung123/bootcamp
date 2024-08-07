import java.util.Scanner;

public class DemoObject {
  public static void main(String[] args) {
    // getClass()
    // java.Lang -> JDK -> library

    // java.lang.StringBuilder -> not need import
    StringBuilder sb = new StringBuilder();

    // java.util.Scanner -> need to import
    Scanner scanner = new Scanner(System.in);

    Object object = new Object(); // Object is a super parent 萬能指針
    object = "hello";
    object = Double.valueOf(0.0d);
    object = new Cat3();

    // All Classes extends Object.class -> inherit all methods from Object.class
    System.out.println(new Cat3().toString()); // I'm a cat.
    System.out.println(new Dog3().toString()); // Dog@74a14482
    
    // Object.hashCode()
    Cat3 c1 = new Cat3();
    Cat3 c2 = new Cat3();
    System.out.println(c1); // I'm a cat.
    System.out.println(System.identityHashCode(c1)); // 356573597
    System.out.println(c1.hashCode()); // generate an int value by object reference -> 356573597
    System.out.println(c2.hashCode()); // 1735600054

    MiniCat mc1 = new MiniCat("John", "red");
    MiniCat mc2 = new MiniCat("John", "red");
    MiniCat mc3 = new MiniCat("John", "RED");
    System.out.println(mc1.hashCode()); // 71864455
    System.out.println(mc2.hashCode()); // 71864455
    System.out.println(mc3.hashCode()); // 71832679

    Object cat = new Cat3();
    // cat Object reference indeed pointing to cat object
    // run() instance method can only be called by object declared by Cat.class
    // if the object reference is declared by Object.class, it cannot call run() method
    // cat.run(); // compile error

    System.out.println();
    // downcast
    // Cat cat2 = cat; // compile error, Java compiler cannot guranteen
    Cat3 cat2 = (Cat3) cat;
    cat2.run();

    // Cat.class inherit Object.class method
    System.out.println(cat2.hashCode()); // 2133927002, cat2 is pointed to cat
    System.out.println(cat2.hashCode()); // 2133927002

    // cat = new DogThree(); // Compile only check: type OK (Relationship: Object and Dog -> Parent and Child)
    // cat2 = (CatThree) cat; // runtime error, java.lang.ClassCastException: class Dog cannot be cast to class Cat

    System.out.println();

    String x1 = new String("abc");
    String x2 = new String("abc");
    System.out.println(x1.hashCode()); // 96354
    System.out.println(x2.hashCode()); // 96354
    System.out.println(x1 == x2); // false, new object

    String x3 = "abc";
    String x4 = "abc";
    System.out.println(x3.hashCode()); // 96354
    System.out.println(x4.hashCode()); // 96354
    System.out.println(x3 == x4); // true, literal pool
  }

  // Java: Ensure Type Safety during complie time (e.g. Object can be pointed to Cat -> not safety)
  // public static Object sum(Object x, Object y) {
  //   return x + y; // "+" operation -> String, Integer, Double, primitives, etc
  // }

  public static int length(String x) {
    return x.length();
  }

  // During complie time, complier cannot ensure the object in heap is a String object
  // public static int length(Object x) {
  //   return x.length(); // The method length() is undefined for the type Object
  // }
}
