public class demoOperator {
  public static void main(String[] args) {
    int x = 3;
    x = x + 3;
    System.out.println("x = " + x); // String + int -> String

    x++; // same as x = x + 1;
    System.out.println("x = " + x);

    ++x; // same as x = x + 1;
    System.out.println("x = " + x);

    x += 2; // same as x = x + 2;
    System.out.println("x = " + x);

    int y = 4;
    y = y - 1; // 3
    y--; // 2
    --y; // 1
    y -= 1; // 0
    System.out.println(y);

    int p = 4;
    p = p * 2; // 8
    p *= 2; // 16
    p /= 4; // 4
    System.out.println(p);

    int z = 10;
    z = z % 3; // 1
    int j = 10;
    j %= 3; // 1
    System.out.println("z = " + z + ", j = " + j);

    String s = "hello";
    s = s + "world"; // helloworld
    s += "!!!"; // helloworld!!!
    System.out.println(s);

    // No ** //

    // >, <, >=, <=
    boolean r1 = 10 > 3; // true
    boolean r2 = 4 > 10; // false
    boolean r3 = 10 >= 10; // true
    boolean r4 = -9 <= 9; // true
    System.out.println(r1+","+r2+","+r3+","+r4);

    // and (&&), or (||)
    boolean r5 = 10 > 3 && 20 >= 20; // true
    boolean r6 = 10 > 3 && 4 < 4; // false
    // boolean r7 = 10 > 3 || 21 > 20; // true
    // boolean r8 = 10 > 3 || 21 < 20; // true OR false -> true
    boolean r9 = 10 < 3 || 21 < 20; // false OR false -> false
    System.out.println(r5+","+r6+","+r9);

    char c10 = 'A';
    char c11 = 'B';
    boolean r10 = c10 == c11; // false
    // boolean r10 = value; -> assign
    // c10 == c11 means equal to
    System.out.println(r10);

    boolean r11 = 'C' != 'D'; // true
    // != means not equal to
    System.out.println(r11);

    boolean r12 = 10 / 2 > 5 * 2; // 5 > 10 -> false
    System.out.println(r12);

    // Challenge
    int n1 = 3;
    int m1 = (n1++ + 3) * n1++;
    // what is m1?
    // 3+3=6, 6*4=24
    System.out.println("m1 = " + m1);
    int n2 = 3;
    int m2 = (n2++ + 3) * ++n2;
    // 3+3=6, 6*5=30
    System.out.println("m2 = " + m2);
    int n3 = 3;
    int m3 = (++n3 + 3) * n3++;
    // 4+3=7, 7*4=28
    System.out.println("m3 = " + m3);
    int n4 = 3;
    int m4 = (++n4 + 3) * ++n4;
    // 4+3=7, 7*5=35
    System.out.println("m4 = " + m4);
  }
}