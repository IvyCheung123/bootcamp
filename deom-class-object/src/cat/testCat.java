package cat;

public class testCat {
  public static void main(String[] args) {
    // Local variable -> all die after main() is completed
    String name = "John";

    // Local variable
    Cat c1 = new Cat(); // "new Cat()" -> produce Cat Object in memory with address
    // c1 -> object reference (point to memory address of Cat Object)
    c1.setName(name);
    System.out.println(c1.getName()); // John
    c1.setAge(10); 
    System.out.println(c1.getAge()); // 10

    // Local variable
    Cat c2 = new Cat();
    c2.setName("Johnny");
    System.out.println(c2.getName()); // Johnny
    c2.setAge(20);
    System.out.println(c2.getAge()); // 20
  }
}
