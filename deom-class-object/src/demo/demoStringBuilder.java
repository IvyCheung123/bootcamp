package demo;

public class demoStringBuilder {
  public static void main(String[] args) {
    // String has slow performance (i.e. concat, replace)
    String s = "hello";
    s += " world";
    System.out.println(s); // hello world
    s = s.replace("e", "xx");
    System.out.println(s); // hxxllo world

    // StringBuilder is a class that has fast performance
    StringBuilder sb = new StringBuilder("hello");

    sb.append(" world");
    System.out.println(sb.toString()); // hello world

    sb.replace(1, 2, "xx"); // return StringBuilder object
    System.out.println(sb.toString()); // hxxllo world

    sb.setCharAt(4, 'A');
    System.out.println(sb.toString()); // hxxlAo world

    sb.reverse();
    System.out.println(sb.toString()); // dlrow oAlxxh

    sb.insert(4, "*");
    System.out.println(sb.toString()); // dlro*w oAlxxh

    sb.deleteCharAt(4);
    System.out.println(sb.toString()); // dlrow oAlxxh

    String s2 = sb.substring(0, 4);
    System.out.println(s2); // dlro
    System.out.println(sb.toString()); // dlrow oAlxxh

    // Arrays and Primitives are the fast
  }
}
