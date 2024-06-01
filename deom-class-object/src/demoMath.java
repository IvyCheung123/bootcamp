public class demoMath {
  public static void main(String[] args) {
    // abs()
    int x = -3;
    int y = 8;
    int result = Math.abs(x * y);
    System.out.println(result); // 24

    double d = 3.3d;
    double result2 = Math.abs(x * d);
    System.out.println(result2); // 9.899999999999999

    long l = 3L;
    long result3 = Math.abs(x * l);
    System.out.println(result3); // 9

    float f = 3.3f;
    float result4 = Math.abs(x * f);
    System.out.println(result4); // 9.9

    // max()
    System.out.println(Math.max(10, 9)); // 10
    System.out.println(Math.max(-10, 9)); // 9

    // min()
    System.out.println(Math.min(10, 9)); // 9
    System.out.println(Math.min(-10, 9)); // -10

    int[] arr = new int[] {4, -3, 10, 2};
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    System.out.println(max); // 10

    // round(): round to int only
    double d2 = 3.65d;
    System.out.println(Math.round(d2)); // 4
    System.out.println(Math.round(3.4d)); // 3
    System.out.println(Math.round(3.5d)); // 4
    System.out.println(Math.round(3.44d)); // 3
    System.out.println(Math.round(3.45d)); // 3

    // pow(): 2^3
    double d3 = Math.pow(2, 3);
    System.out.println(d3); // 8.0
    System.out.println(Math.pow(2.2, 3)); // 10.648000000000003

    // sqrt()
    System.out.println(Math.sqrt(25)); // 5.0
    System.out.println(Math.sqrt(24)); // 4.898979485566356
    System.out.println(Math.sqrt(-25)); // NaN -> cannot sqrt negative value

    // random()
    System.out.println(Math.random()); // between 0.0 and 1.0
    System.out.println(Math.round(Math.random() * 100)); // between 0 and 100
  }
}
