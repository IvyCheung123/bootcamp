public class demoString {
  public static void main(String[] args) {
    double price = 9.99;
    String item = "Book";
    String description = "The " + item + "'s cost = $" + price;
    // String + String + double -> String
    System.out.println(description);

    char a = 'A';
    String msg = "The answer is: " + a;
    System.out.println(msg); // String + char -> String

    // String Method (Tool) 1: length()
    String t = "hello";
    System.out.println("The length of hello = " + t.length()); // t.length -> int

    // check if t length >=4, if you, print hello, else goodbye
    if (t.length() >= 4) {
      System.out.println("hello");
    } else {
      System.out.println("goodbye");
    }

    // Method 2: equals()
    String s1 = "hello";
    String s2 = "hello";
    if (s1.equals(s2)) {
      System.out.println("They are having same String value");
    } else {
      System.out.println("They are not with same value");
    }
    // ! means NOT
    if (!s1.equals(s2)) {
      System.out.println("They are not with same value");
    } else {
      System.out.println("They are having same String value");
    }

    if (s1 == s2) {
      System.out.println("Check if they are same object");
    }

    // check if s1 length >= 6 or s1 equals s2, print
    if (s1.length() >= 6 || s1.equals(s2)) {
      System.out.println("s1 length >= 6 or s1 equals s2");
    } else {
      System.out.println("false");
    } // false || true -> true

    if (s1.length() >= 6) {
    System.out.println("hello world");
    } else if (s1.equals(s2)) {
      System.out.println("hello");

    if (s1.length() >= 6 && s1.equals(s2)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    } // false && true -> false

    if (s1.length() >= 6) {
      if (s1.equals(s2)) {
        System.out.println("hello");
      } else if (!s1.equals(s2)) {
        System.out.println("false");
      }
    }  // same with above (&&)

    // Method 3: charAt (int index), e.g. charAt(0)
    String s3 = "world";
    // 0 means the 1st character
    // 1 means the 2nd character
    // 4 means the 5st character
    System.out.println("The 1st character of world = " + s3.charAt(0)); //w
    // s3.charAt(-1); // java.lang.StringIndexOutOfBoundException
    // s3.charAt(5); // java.lang.StringIndexOutOfBoundException

    System.out.println("The last character of world = " + s3.charAt(s3.length()-1));
    }

    // check if the last character is d and length > 5, if yes, print yes
    String s4 = "hello world";
    if (s4.charAt(s4.length()-1) == 'd' && s4.length() > 5) {
      System.out.println("yes");
    } else {
      System.out.println("false");
    }

    // Method 4: substring (int beginIndex, int endIndex)
    String result = s4.substring(0, 2);
    System.out.println(result); // "he" (beginIndex to endIndex -1)
    System.out.println(s4.substring(3, 8)); // "lo wo"
    System.out.println(s4.substring(0, 0)); // ""
    // System.out.println(s4.substring(0, -1)); // error

    // check if the first three character is "wel", if yes, print yes
    String s5 = "welcome";
    // substring()
    if (s5.substring(0, 3).equals("wel")) {
      System.out.println("yes");
    }
    // chain method
    System.out.println(s5.substring(0, 3).length()); // 3
    System.out.println(s5.substring(0, 3).charAt(1)); // 'e'
    /*
     * String x1 = s5.substring(0, 3); // String "wel"
     * int x2 = x1.length(); // 3
     * System.out.println(x2); // same with above
     */
    // charAt()
    if (s5.charAt(0) == 'w' && s5.charAt(1) == 'e' && s5.charAt(2) == 'l') {
      System.out.println("yes");
    }

    // equals() compares content, == compares memory location
    // why String " " uses equals() but not == ?
    // why char ' ' uses == but not equals() ?
    String ss = "welcome";
    String sub = ss.substring(0, 3);
    if (ss == sub) {
      System.out.println("ss == sub");
    } else {
      System.out.println("false");
    }
  }
}  
