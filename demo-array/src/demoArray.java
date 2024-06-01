import java.util.Arrays;

public class demoArray {
  public static void main(String[] args) {
    // when you create an array object, you have to define the length of it
    int[] arr = new int[3]; // store int value only, and the length = 3
    // arr[index]
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = -3;

    // Complie-time Exception
    // arr [0] = "hello"; // java complier knows that "arr" is an int array
    System.out.println(arr[0]); // 10
    System.out.println(arr[1]); // 20
    System.out.println(arr[2]); // -3

    arr[1] = 100; // replace
    System.out.println(arr[1]); // 100

    // Run-time Exception
    // arr[3] = 200; // java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

    int[] arr2 = new int[] {10, 20, -3};
    System.out.println(arr2[0]); // 10
    System.out.println(arr2[1]); // 20
    System.out.println(arr2[2]); // -3

    // String array -> "hello", "abc", "ijk"
    String[] str = new String[] {"hello", "abc", "ijk"};
    System.out.println(str[0]);
    System.out.println(str[1]);
    System.out.println(str[2]);

    // upgrade?
    long[] l = new long[] {1, 2, 3};

    // Method: Arrays.
    // Choose and enter to "import java.util.Arrays;"" after typed Arrays
    System.out.println(Arrays.toString(str)); // ["hello", "abc", "ijk"]
    System.out.println(Arrays.toString(arr2)); // [10, 20, -3]

    // 9, -3, -100, 90, 66, -4
    // for loop, print out all
    int[] arr3 = new int[] {9, -3, -100, 90, 66, -4};
    for (int i = 0; i < arr3.length; i++) {
      System.out.println(arr3[i]);
    }
    // for loop
    // find the max value from arr3
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr3.length; i++) {
      if (arr3[i] > max) {
        max = arr3[i];
      }
    }
    System.out.println("max = " + max);

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr3.length; i++) {
      if (arr3[i] < min) {
        min = arr3[i];
      }
    }
    System.out.println("min = " + min);

    // Exercise
    char[] arr4 = new char[] {'l', 'e', 'e', 'r', 'q'};
    // 1. count number of 'e'
    int count = 0;
    char target = 'e';
    for (int i = 0; i < arr4.length; i++) {
      if (arr4[i] == target) {
        count++;
      }
    }
    System.out.println("Number of '" + target + "' = " + count);

    // 2. boolean result to store if 'r' exist
    boolean isR = false;
    for (int i = 0; i < arr4.length; i++) {
      if (arr4[i] == 'r') {
        isR = true;
        break;
      }
    }
    System.out.println("Does 'r' exist? Ans = " + isR);

    // 3. String result to store "qreel"
    String reversed = "";
    // arr4.length = 5 // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    for (int i = arr4.length - 1; i >= 0; i--) {
      reversed += arr4[i];
    }
    System.out.println("reversed = " + reversed);

    // 4. Given two char[] -> append all characters to a String value
    char[] c1 = new char[] {'a', 'b', 'c', 'd'};
    char[] c2 = new char[] {'1', '2', '3', '4'};

    // 4a. result -> "abcd1234"
    String fourA = "";
    for (int i = 0; i < c1.length; i++) {
      fourA += c1[i]; // String value + char -> String
    }
    for (int i = 0; i < c2.length; i++) {
      fourA += c2[i];
    }
    System.out.println("fourA = " + fourA);

    // 4b. result -> when even index, get value from c1, when odd index, get from c2 -> "a2c4"
    // Approach 1:
    String fourB = "";
    int length = c1.length > c2.length ? c1.length : c2.length;
    /*
     * if (c1.length > c2.length) {
     *  length = c1.length;
     * } else {
     *  length = c2.length;
     * }
     */
    for (int i = 0; i < length; i++) {
      if (i % 2 == 0) {
        fourB += c1[i];
      } else {
        fourB += c2[i];
      }
    }
    System.out.println("fourB = " + fourB);
    
    // 4b (challenge). result -> "a2c4a"
    char[] c3 = new char[] {'a', 'b', 'c', 'd', 'a', 'b'};
    char[] c4 = new char[] {'1', '2', '3', '4'};
    String fourC = "";
    int length2 = c3.length > c4.length ? c3.length : c4.length;
    for (int i = 0; i < length2; i++) {
      if (i % 2 == 0 && i < c3.length) {
        fourC += c3[i];
      } else if (i % 2 == 1 && i < c4.length) {
        fourC += c4[i];
      }
    }
    System.out.println("fourB = " + fourC);

    // average
    int[] arr5 = new int[] {4, 8, 3};
    int sum5 = 0;
    int count5 = 0;
    for (int i = 0; i < arr.length; i++) {
      sum5 += arr5[i]; // 15
      count5++; // 3
    }
    System.out.println(sum5 / count5); // 15 / 3 = 5

    // swapping in array
    int temp = 0;

    int[] arr6 = new int[] {6, 10, -4, 15};
    // swap -4 and 6 -> [-4, 10, 6, 15]
    temp = arr6[2];
    arr6[2] = arr6[0];
    arr6[0] = temp;
    System.out.println(Arrays.toString(arr6)); // [-4, 10, 6, 15]

    // Level 1:
    // move -4 to the tail of the array -> [10, 6, 15, -4]
    for (int i = 0; i < arr6.length - 1; i++) {
      temp = arr6[i];
      arr6[i] = arr6[i + 1];
      arr6[i + 1] = temp;
    }
    System.out.println(Arrays.toString(arr6)); // [10, 6, 15, -4]

    // Level 2:
    // move the max to the tail
    // Now: [10, 6, 15, -4]
    // 1st round: [6, 10, 15, -4]
    // 2nd round: [6, 10, 15, -4]
    // 3rd round: [6, 10, -4, 15]
    for (int i = 0; i < arr6.length - 1; i++) {
      if (arr6[i] > arr6[i + 1]) {
        temp = arr6[i];
        arr6[i] = arr6[i + 1];
        arr6[i + 1] = temp;
      }
    }
    System.out.println(Arrays.toString(arr6)); // [6, 10, -4, 15]

    // Level 3:
    // Now: [6, 10, -4, 15]
    // Sorting -> [-4, 6, 10, 15]
    // for loop
    // nested loop
    for (int i = 0; i < arr6.length - 1; i++) { // 0 1 2
      for (int j = i + 1; j < arr6.length; j++) { // 1 2 3
    /* for (int j = 0; j < arr6.length - 1 - i; j++) {
        if (arr6[j] > arr6[j + 1]) {
          temp = arr6[j];
          arr6[j] = arr6[j + 1];
          arr6[j + 1] = temp;
        }
    */
        if (arr6[i] > arr6[j]) {
          temp = arr6[i];
          arr6[i] = arr6[j];
          arr6[j] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(arr6)); // [-4, 6, 10, 15]
    
    // swap char value
    String str7 = "hello"; // swap e and o -> "holle"
    // char[] arr7 = new char[str7.length()];
    char chr7 = ' ';
    /*
    for (int i = 0; i < str7.length(); i++) {
      arr7[i] = str7.charAt(i);
    }
    */
    // Alternative (String -> char[])
    char[] arr7 = str7.toCharArray(); // ['h', 'e', 'l', 'l', 'o']
    System.out.println(arr7); // hello
    System.out.println("arr7 = " + arr7); // [C@3d4eac69
    System.out.println("arr7 = " + Arrays.toString(arr7)); // [h, e, l, l, o]
    chr7 = arr7[1];
    arr7[1] = arr7[4];
    arr7[4] = chr7;
    str7 = String.valueOf(arr7); // assign a new String value to variable str7
    System.out.println(str7); // "holle"
  }
}
