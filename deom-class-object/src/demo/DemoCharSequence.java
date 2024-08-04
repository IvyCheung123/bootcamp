package demo;

public class DemoCharSequence {
  public static void main(String[] args) {
    String s = "abc";
    System.out.println(s.length()); // 3
    System.out.println(s.replace("c", "a")); // aba

    CharSequence cs = "abc";
    System.out.println(cs.length()); // 3 (polymorphism)
    System.out.println(cs.charAt(1)); // b
    // cs.replace(); // replace() is not included in CharSequence Interface

    // Both Parent Class and Interface relationship can apply "downcasting"
    // String s2 = (String) cs;
    // // As java developer, you may use "instanceof" to ensure the type-safety
    // if (cs instanceof String) {
    //   s2 = (String) cs;
    // }
    // System.out.println(s2.replace("b", "d")); // adc

    StringBuilder sb = new StringBuilder("hello");
    System.out.println(sb.length()); // 5
    System.out.println(sb.charAt(1)); // e
    System.out.println(sb.reverse()); // olleh

    CharSequence cs2 = new StringBuilder("hello");
    System.out.println(cs2.length()); // 5
    System.out.println(cs2.charAt(1)); // e
    // cs2.reverse();  // reverse() is not included in CharSequence Interface

    CharSequence cs3 = new String();
    StringBuilder sb2 = (StringBuilder) cs3; // run-time error
    // cs point to String object now
    // but object reference sb2 is StringBuilder
  }
}
