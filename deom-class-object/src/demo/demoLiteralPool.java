package demo;

public class demoLiteralPool {
  public static void main(String[] args) {
    // Literal Pool (String)
    String s1 = "hello";
    String s2 = "hello";
    System.out.println(System.identityHashCode(s1)); // 1933863327
    System.out.println(System.identityHashCode(s2)); // 1933863327
    System.out.println(s1 == s2); // true

    String s3 = "hello";
    String s4 = new String("hello");
    System.out.println(System.identityHashCode(s3)); // 1933863327
    System.out.println(System.identityHashCode(s4)); // 112810359
    System.out.println(s3 == s4); // false

    s3 = s4;
    System.out.println(System.identityHashCode(s3)); // 112810359
    System.out.println(System.identityHashCode(s4)); // 112810359
    System.out.println(s3 == s4); // true, they are pointing to the same object

    String s5 = "he";
    String s6 = "llo";
    System.out.println(System.identityHashCode(s5)); // 1704024323
    System.out.println(System.identityHashCode(s6)); // 696049941
    s5 = s5 + s6; // s5 = hello
    System.out.println(System.identityHashCode(s5)); // 2124308362
    System.out.println(s1 == s5); // false

    String s7 = "he";
    String s8 = "llo";
    System.out.println(System.identityHashCode(s7)); // 1704024323
    System.out.println(System.identityHashCode(s8)); // 696049941
    s7 = s7.concat(s8); // s7 = hello
    System.out.println(System.identityHashCode(s7)); // 146589023
    System.out.println(s1 == s7); // false

    // Immutable
    String s9 = "hello";
    System.out.println(System.identityHashCode(s9)); // 1933863327
    s9 += " world";
    System.out.println(System.identityHashCode(s9)); // 349885916

    String s10 = "hello";
    System.out.println(System.identityHashCode(s10)); // 1933863327
    s10 = s10.replace("e", "e");
    System.out.println(System.identityHashCode(s10)); // 1933863327

    String s11 = "hello";
    System.out.println(System.identityHashCode(s11)); // 1933863327
    s11 = s11.toUpperCase();
    System.out.println(System.identityHashCode(s11)); // 414493378
    
    String s12 = "hello";
    System.out.println(System.identityHashCode(s12)); // 1933863327
    s12 = s12.substring(0, 5); // hello
    System.out.println(System.identityHashCode(s12)); // 1933863327
    s12 = s12.substring(0, 2); // he
    System.out.println(System.identityHashCode(s12)); // 1984697014
  }
}
