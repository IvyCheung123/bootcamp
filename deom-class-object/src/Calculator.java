public class Calculator {
  private int x;
  private int y;

  // Static method -> Instance method
  public static int sum(int x, int y) {
    return x + y;
  }

  // Instance method
  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }
  
  public int sum2() {
    return this.x + this.y;
  }
  public int multiply() {
    return this.x * this.y;
  }

  public static void main(String[] args) {
    System.out.println(sum(1, 3)); // 4
    System.out.println(Calculator.sum(2, 4)); // 6

    Calculator c1 = new Calculator();

    c1.setX(2);
    c1.setY(3);

    System.out.println(c1.sum2()); // 2 + 3 = 5
    System.out.println(c1.multiply()); // 2 * 3 = 6
  }
}
