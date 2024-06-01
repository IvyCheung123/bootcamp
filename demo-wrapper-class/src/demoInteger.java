public class demoInteger {
  public static void main(String[] args) {
    int x = 1;
    Integer x2 = 1;
    System.out.println(x);
    System.out.println(x2);
    
    x = x + 3;
    x -= 10;

    x2 = x2 + 3;
    x2 -= 10;

    // Integer is a wrapper class of int value
    // class has method
    short s = (short) x;
    // short s2 = (short) x2; // error, Cannot cast from Integer to short

    x2 += 60000;
    short s2 = x2.shortValue(); // overflow, similar to explicit conversion
    System.out.println(s2); // -5542

    double d1 = x2.doubleValue();
    System.out.println(d1); // 1 + 3 - 10 + 60000 = 59994.0
    
    // Comparison
    // Primitives use > < >= <= == != for int value
    // Wrapper Class use compareTo() method
    Integer x3 = 4; // autobox
    Integer x4 = 8; // autobox
    Integer x5 = 8; // autobox
    boolean result = x4 > x3; // true (compare int value)
    System.out.println(result);

    System.out.println(x4.compareTo(x3)); // 1 (left > right)
    System.out.println(x3.compareTo(x4)); // -1 (left < right)
    System.out.println(x4.compareTo(x5)); // 0 (left = right)

    boolean result2 = x4.compareTo(x3) > 0; // true, compare Integer value
    System.out.println(result2);

    // compare Integer value
    boolean result3 = x4.compareTo(x3) > 0; // true
    boolean result4 = x4.compareTo(x3) < 0; // false
    boolean result5 = x4.compareTo(x5) == 0; // true
    System.out.println(result3);
    System.out.println(result4);
    System.out.println(result5);

    // Byte, Short, Integer, Long, Double, Float
    Float f1 = 10.0f; // 10.0f is a float value -> autobox -> Float value
    Float f2 = new Float(10.0f); // create Float object, storing a float value
    long l1 = f2.longValue();

    Double d2 = new Double(10.3d);
    long l2 = d2.longValue();
    System.out.println(l2); // 10

    // String method -> incident method?
    // Wrapper class -> static method
    Character c1 = new Character('A');
    char c2 = Character.toUpperCase('b'); // static method
    System.out.println(c2); // B
    System.out.println(Character.toLowerCase(c1)); // a

    Boolean b1 = new Boolean(false);
    Boolean b2 = new Boolean(true);
    Boolean b3 = new Boolean(true);

    // compareTo() method is used to compare the boolean value stored in Boolean object
    System.out.println(b1.compareTo(b2)); // -1
    System.out.println(b2.compareTo(b3)); // 0

    System.out.println(b1 == b2); // false
    System.out.println(b2 == b3); // false???

    // autobox and unbox
    Integer i1 = 9; // 9 is an int value -> autobox -> Integer object
    int i2 = i1; // i1 is Integer object -> unbox -> int value

    Integer i3 = new Integer(9);
    int i4 = i3.intValue();

    Integer i5 = Integer.valueOf(9); // static method, the result is as same as "new Integer(9)"
    int i6 = Integer.parseInt("10");
    System.out.println(i6); // 10

    /*
    int i6 = Integer.parseInt("abc");
    System.out.println(i6); // error, java.lang.NumberFormatException
    */

    System.out.println(new Byte("10"));
    // System.out.println(new Byte(10)); // error, because no 10b
    System.out.println(new Byte((byte) 10));
  }
}
