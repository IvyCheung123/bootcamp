public class Ball {
  private double weight;
  private String color;
  private int number;

  // Custom empty constructor
  public Ball() {
    this.color = "White";
  }

  // All arguments constructor
  public Ball(double weight, String color) {
    this.weight = weight;
    this.color = color;
  }
  /*
  public Ball(double weight2, String color2) {
    this.weight = weight2;
    this.color = color2;
  }
  */
  public Ball(double weight, String color, int number) {
    this(weight, color); // call self constructor
    this.number = number;
  }

  // Setter
  public void setWeight (double weight) {
    this.weight = weight;
  }

  public void setColor (String color) {
    this.color = color;
  }

  // Getter
  public double getWeight() {
    return this.weight;
  }

  public String getColor() {
    return this.color;
  }

  /*
  public String toString() {
    return "Weight: " + this.weight + ", Color: " +this.color;
  }
  */

  public static void main(String[] args) {
    Ball b1 = new Ball(); // Custom empty constructor
    System.out.println(b1.toString()); // Ball@7344699f (object reference)

    Ball b2 = new Ball(10.2, "Black"); // All arguments constructor
    System.out.println(b2.toString()); // Ball@6b95977 (object reference)
  }
}
