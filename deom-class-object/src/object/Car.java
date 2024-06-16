package object;

public class Car {
  private static int count = 0;
  private int id;
  private String color;

  // Constructor can access static variable
  public Car(String color) {
    this.id = ++count;
    this.color = color;
  }

  public int getId() {
    return this.id;
  }

  public static void main(String[] args) {
    Car c1 = new Car("red");
    Car c2 = new Car("yellow");
    Car c3 = new Car("blue");
    System.out.println(c3.getId()); // 3
  }
}
