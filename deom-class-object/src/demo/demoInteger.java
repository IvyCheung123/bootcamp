package demo;

public class demoInteger {
 public static void main(String[] args) {
  Integer i1 = Integer.valueOf(127); // 127 -> (1st) create Integer object
  Integer i2 = 127; // 127 -> (2nd) reuse the original Integer object
  System.out.println(i1 == i2); // true, same object
  System.out.println();

  // Integer (internal cache: -128 to 127)
  Integer i3 = Integer.valueOf(128); // 128 -> (1st) create Integer object
  Integer i4 = Integer.valueOf(128); // 128 -> (2nd) create Integer object
  System.out.println(i3.equals(i4)); // true, same content 128
  System.out.println(i3.compareTo(i4)); // 0, same value 128
  System.out.println(i3 == i4); // false, different memory location (diiferent object)

  // Float, Double (no internal cache in JVM)
  Float f1 = Float.valueOf(10.12345f); // no cache -> create Float object
  Float f2 = Float.valueOf(10.12345f); // no cache -> create Float object
  System.out.println(f1 == f2); // false
  Double d1 = Double.valueOf(128.12345d); // no cache -> create Double object
  Double d2 = Double.valueOf(128.12345d); // no cache -> create Double object
  System.out.println(d1 == d2); // false

  // Boolean (internal cache: true, false)
  Boolean b1 = Boolean.valueOf(true);
  Boolean b2 = Boolean.valueOf(true);
  System.out.println(b1 == b2); // true

  // Character (internal cache: -128 to 127)
  Character c1 = Character.valueOf('a');
  Character c2 = Character.valueOf('a');
  System.out.println(c1 == c2); // true
  Character c3 = Character.valueOf('你');
  Character c4 = Character.valueOf('你');
  System.out.println(c3 == c4); // false
 } 
}
