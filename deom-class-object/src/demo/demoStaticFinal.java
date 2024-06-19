package demo;

public class demoStaticFinal {

  // final is a java keyword, complier will check all final variables have been initialized
  // Constant 常量 -> use snakecase 大階
  // private static final String LOGO_STRING = "default"; // finalized static variables
  private static final String LOGO_STRING; // can be initialized in static block
  // but cannot be initialized in main() because static block is running before main() and main() = runtime, it's too late
  // Non-constant -> use camelcase 細階 (e.g. logo)
  // private static String logo = "default";
  private static String name; // static variables

  private final double salary = 0.0d; // finalized instance variables

  private int age; // instance variables

  static {
    LOGO_STRING = "default";
  }

  public int getAge() {
    return this.age;
  }

  public double getSalary() {
    return this.salary;
  }

  // Instance method can access both instance and static variables
  public String test() {
    return "Age: " + this.age + ", Salary: " + this.salary + ", Name: " + name + ", Logo: " + LOGO_STRING;
  }

  public static String getName() {
    return name;
  }

  public static String getLogo() {
    return LOGO_STRING;
  }

  public static void main(String[] args) {

    demoStaticFinal dsf = new demoStaticFinal();
    dsf.age = 10;
    System.out.println(dsf.age); // 10
    System.out.println(dsf.salary); // 0.0

    demoStaticFinal.name = "abc";
    System.out.println(demoStaticFinal.name); // abc
    System.out.println(demoStaticFinal.LOGO_STRING); // default

  }

}
