package demo;

public class demoBlock {
  
  // Static variables
  private static int number;
  private static int number2;

  // Instance variables
  private String name;

  // Static block
  // 1. Trigger once only, no matter the number of static variable(s), even no static variable
  static {
    System.out.println("start static block");
    // number = 1;
    // number2 = 2;
    System.out.println("end static block");
  }

  public demoBlock() {
    System.out.println("calling empty constructor ...");
  }

  public demoBlock(String name) {
    System.out.println("calling all args constructor ...");
    this.name = name;
  }

  // Instance block
  // 1. It is triggered when there is new object created in this class
  // 2. It is triggered before constructor
  // 3. Usage: common logic between constructors
  {
    System.out.println("start instance block");
    this.name = "John";
    System.out.println("end instance block");
  }

  public static void main(String[] args) {
    System.out.println("start");
    // System.out.println(demoBlock.number); // 1
    // System.out.println(demoBlock.number2); // 2
    // number = 10;
    // System.out.println(demoBlock.number); // 10

    demoBlock db = new demoBlock();
    demoBlock db2 = new demoBlock("abc");
    demoBlock db3 = new demoBlock();
    System.out.println("end");
  }
}
