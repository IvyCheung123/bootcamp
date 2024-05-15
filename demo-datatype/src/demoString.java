public class demoString {
  public static void main(String[] args) {
    // String (use double quote to declare a String value)
    // String stores text
    // String is not Primitive data type
    String q = "Hello", w = " World";
    System.out.println(q + w);
    String e = "I am ";
    String r = "Alan.";
    String er = e + r;
    System.out.println(er);

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
      System.out.println("yes\n");
    }

    // equals() compares content, while == compares object or memory location
    String z1 = "welcome";
    String z2 = "welcome";
    String z3 = "wel";

    String z4 = new String("welcome");
    String z5 = new String("welcome");
    String z6 = new String ("wel");

    String z7 = z1.substring(0, 7); // "welcome"
    String z8 = z1.substring(0, 3); // "wel"
    String z9 = z8.substring(0, 3); // "wel"

    System.out.println(z1.equals(z2) && z1.equals(z4) && z3.equals(z6) && z1.equals(z7) && z6.equals(z8)); // true
    System.out.println(z1 == z2); // true -> same location with same sub-location
    System.out.println(z1 == z3); // false -> same location but different sub-location (welcome vs wel)
    System.out.println(z1 == z4); // false -> new location, so different location
    System.out.println(z4 == z5); // false -> two new independent location, so different location
    System.out.println(z1 == z7); // true -> z7 point to z1, same location
    System.out.println(z3 == z8); // false -> z8 point to z1 location, z1 and z3 are different location
    System.out.println(z8 == z9); // true -> z9 point to z8, same location

    System.out.println("\b");
    // Primitives are compared with ==
    // Convert char to wrapper classes Character to use equals()
    /*
     * String z1 = "welcome";
     * String z2 = "welcome";
     * String z3 = "wel";
     * 
     * String z6 = new String ("wel");
     */
    char x1 = 'w';
    char x2 = z1.charAt(0); // 'w'
    char x3 = z3.charAt(0); // 'w'
    char x4 = z6.charAt(0); // 'w'
    System.out.println(x1 == x2); // true
    System.out.println(x1 == x3); // true
    System.out.println(x1 == x4); // true -> ???
    Character y1 = 'w';
    Character y2 = z1.charAt(0); // 'w'
    System.out.println(y1 == y2); // true
    System.out.println(y1.equals(y2)); // true
  }
}  
