public class demoPrimitives2 {
  public static void main(String[] args) {
    long l1 = 10; // int value
    long l2 = 10L; // long value

    // Java: int -> long
    long l3 = 63; // assign int value 63 to long value l3 (int -> long value)

    // Can upgrade:
    // byte -> short -> int -> long -> float -> double
    // char -> int (ascii)
    byte b1 = 10; // ok, why? int value -> byte
    short s1 = 10; // ok

    // You can only explicitly assign a value that with a type higher than the data type
    float f1 = (float) 1.9d; // downcast (overflow / precision lost) because complier doesn't care the value (1.9)

    short s2 = 128;
    byte b2 = (byte) s2;
    System.out.println("b2 = " + b2); // -128 -> overflow
    s2 = 129;
    b2 = (byte) s2;
    System.out.println("b2 = " + b2); // -127 -> overflow
    
    byte b3 = 127;
    short s3 = b3; // no risk, within the range of short value
    System.out.println("s3 = " + s3);

    double d1 = 10.9d;
    int i1 = (int) d1;
    System.out.println("i1 = " + i1); // 10 -> precision lost

    // char -> int (ascii)
    char c1 = 'a'; // 97
    char c2 = 'A'; // 65
    if (c1 == c2) {
      System.out.println("true, 97 == 65");
    } else {
      System.out.println("false, 97 != 65");
      System.out.println("'a' -> ascii 97 = " + c1); // String + char -> String
      System.out.println("'a' -> ascii 97 = " + (int) c1); // String + int -> String
    }
    if (c1 > c2) {
      System.out.println("true, 97 > 65");
    }

    int c1InValue = c1; // char -> int (upcast) -> range ok, no risk

    int charValue = 97;
    char c3 = (char) charValue; // (char) -> conversion
    System.out.println("c3 = " + c3); // a

    char c4 = '你';
    int i4 = c4;
    System.out.println("'你' = " + i4); // 20320

    // ascii: remember '0' = 48, 'a' = 95, 'A' = 67

    char character = 'a' + 1; // char + int -> int + int
    System.out.println(character); // b
    int asciiCode = character;
    System.out.println(asciiCode); // 98

    // 228
    int x = 228;
    char xChar = (char) x;
    System.out.println(xChar);

    char sum = 'Σ';
    int sumASCII = sum;
    System.out.println(sumASCII); // 931

    short a = (byte) 128; // int -> byte -> short (downcast -> upcast)
    System.out.println(a); // -128

    byte b5 = (byte) 128; // meaningless
    short s5 = (byte) 128;
    System.out.println(b5);

    // Challenge
    byte value = 127;
    for (int i = 0; i < 10; i++) {
      value++;
      System.out.println("value = " + value);
    } // 127 128 129 130 131 132 133 134 135 136
    // -> -128 -127 -126 -125 -124 -123 -122 -121 -120 -119
  }
}
