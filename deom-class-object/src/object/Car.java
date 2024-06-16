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

  public String toString() {
    return "ID: " + this.id + ", Color: " + this.color;
  }

  public static void main(String[] args) {
    Car c1 = new Car("red");
    Car c2 = new Car("yellow");
    Car c3 = new Car("blue");
    System.out.println(c1.toString()); // ID: 1, Color: red
    System.out.println(c2.toString()); // ID: 2, Color: yellow
    System.out.println(c3.toString()); // ID: 3, Color: blue
  }
}
