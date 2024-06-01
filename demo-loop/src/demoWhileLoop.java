import java.util.Arrays;

public class demoWhileLoop {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      System.out.println(i);
    }

    System.out.println();

    int i = 0;
    while (i < 5) {
      System.out.println(i);
      i++;
    }

    System.out.println();

    int sum = 0;
    i = 0;
    int[] arr = new int[] {10, -100, 9, 7};
    while (i < arr.length) {
      sum += arr[i];
      i++;
    }
    System.out.println("sum = " + sum);

    i = 0;
    while (i < 100) {
      if (i > 30) {
        break;
      }
      i++;
    }
    System.out.println("i = " + i); // 31

    System.out.println();

    // 123 -> 1 + 2 + 3 -> 6
    // 100 -> 1 + 0 + 0 -> 1
    // 4563 -> 4 + 5 + 6 + 3 -> 18
    i = 0;
    /*
    String str1 = "123";
    char[] arr1 = str1.toCharArray();
    */
    int a = 123;
    sum = 0;
    while (a > 0) {
      sum += a % 10; // 3 + 2 + 1
      a /= 10; // 0
    }
    System.out.println("sum = " + sum);

    System.out.println(1 % 10); // 1
    int x = 1;
    System.out.println(x = x / 10); // 0

    System.out.println();

    // reverse number
    // 54321 -> 12345
    // 101 -> 101
    i = 0;
    String b = "54321";
    char[] arr2 = b.toCharArray();
    while (i < arr2.length - 1) {
      int j = i + 1;
      while (j < arr2.length) {
        if (arr2[i] > arr2[j]) {
          char temp = arr2[i];
          arr2[i] = arr2[j];
          arr2[j] = temp;
        }
        j++;
      }
      i++;
    }
    b = String.valueOf(arr2);
    System.out.println(b);
  }
}
