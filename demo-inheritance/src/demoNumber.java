public class demoNumber {
  public static void main(String[] args) {
    Integer num1 = Integer.valueOf(1);
    System.out.println(num1.getClass()); // class java.lang.Integer

    Double num2 = Double.valueOf(2.0d);
    System.out.println(num2.getClass()); // class java.lang.Double

    // Polymorphism 多態性
    Number num3 = num1; // class java.lang.Integer
    num3 = num2; // class java.lang.Double

    Number[] numbers =
        new Number[] {1, 2.0, (byte) 3, (short) 4, 5L};
    Double[] doubles = new Double[] {Double.valueOf(1), 2.0};
    // Double[] doubles = new Double[] {1, 2.0};
    // int -> Integer (autoboxing)
    // Integer vs Double (no relationship)
    // int vs double (upcast)

    // for-each
    // for (object type : array object)
    for (Number num : numbers) {
      System.out.println(num.getClass());
    }
    // class java.lang.Integer
    // class java.lang.Integer
    // class java.lang.Integer
    // class java.lang.Double
    // class java.lang.Double
    // class java.lang.Byte
    // class java.lang.Short
    // class java.lang.Long
  }
}
