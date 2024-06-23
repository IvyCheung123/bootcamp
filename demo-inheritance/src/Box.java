import java.math.BigDecimal;

public class Box { // similar to StringBuilder
  private String x;

  public Box() {
    this.x = "";
  }

  public Box append(String y) {
    this.x += y;
    return this;
  }

  public String toString() {
    return this.x;
  }

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("hello");
    System.out.println(sb); // hello

    Box box = new Box();
    box.append("hello");
    System.out.println(box); // hello

    BigDecimal bd = new BigDecimal(0.0d);
    bd.add(BigDecimal.valueOf(1.0d)); // new BigDecimal
    System.out.println(bd.doubleValue()); // 0.0
    bd = bd.add(BigDecimal.valueOf(1.0d));
    System.out.println(bd.doubleValue()); // 1.0
  }
}
