import java.math.BigDecimal;

public class NumberBox<T extends Number> {
  private T number;

  public NumberBox(T number) {
    this.number = number;
  }

  public static void main(String[] args) {
    NumberBox<Byte> byteBox = new NumberBox<>((byte) 1); // int -> byte -> Byte
    // Byte extends Number & Long extends Number
    // NumberBox<Byte> has no relationship with NumberBox<Long>
    // byteBox = new NumberBox<Long>(); // error
    NumberBox<BigDecimal> bdBox = new NumberBox<>(BigDecimal.valueOf(1.0d));
  }
}
