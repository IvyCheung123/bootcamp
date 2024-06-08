public class demoInteger {
 public static void main(String[] args) {
  Integer i1 = Integer.valueOf(127); // 127 -> (1st) create Integer object
  Integer i2 = 127; // 127 -> (2nd) reuse the original Integer object
  System.out.println(i1 == i2); // true, same object

  // Integer cache for number (-128 to 127)
  Integer i3 = Integer.valueOf(128); // 128 -> (1st) create Integer object
  Integer i4 = Integer.valueOf(128); // 128 -> (2nd) create Integer object
  System.out.println(i3.equals(i4)); // true, same content 128
  System.out.println(i3.compareTo(i4)); // 0, same value 128
  System.out.println(i3 == i4); // false, different memory location (diiferent object)
 } 
}
