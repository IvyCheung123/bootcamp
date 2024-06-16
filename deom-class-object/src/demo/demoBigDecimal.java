package demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class demoBigDecimal {
  public static void main(String[] args) {
    double x = 0.2;
    double y = 0.1;
    System.out.println(x * y); // 0.020000000000000004

    BigDecimal b1 = new BigDecimal("0.2");
    BigDecimal b2 = new BigDecimal("0.1");

    BigDecimal b3 = b1.multiply(b2);
    System.out.println(b3);
    System.out.println(b3.doubleValue()); // 0.02

    // Call method (sum)
    System.out.println(0.1 + 0.2); // 0.30000000000000004
    System.out.println(sum(0.2, 0.1)); // 0.3

    // Call method (division)
    System.out.println(9.9 / 3.2); // 3.09375
    System.out.println(division(9.9, 3.2)); // 3.09375 -> 3.094
    // System.out.println(division(10, 3)); // java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result

    // d1.subtract().multiply() -> 會唔會先乘除後加減? No
    System.out.println(BigDecimal.valueOf(3.3)
    .subtract(BigDecimal.valueOf(1.1))
    .multiply(BigDecimal.valueOf(4.4))); // (3.3 - 1.1) * 4.4 = 9.68

    // System.out.println("hello"); // 1 ms
  }

  public static double sum(double d1, double d2) {
    BigDecimal b1 = BigDecimal.valueOf(d1);
    BigDecimal b2 = BigDecimal.valueOf(d2);
    return b1.add(b2).doubleValue();
  }

  public static double division(double d1, double d2) {
    // handle non-terminating decimal expansion (i.e. 10 / 3)
    return BigDecimal.valueOf(d1).divide(BigDecimal.valueOf(d2))
    .setScale(3, RoundingMode.UP) // decimal place, the way to round the result
    .doubleValue(); // convert from BigDecimal to double
  }
}
