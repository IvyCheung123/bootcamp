import java.util.List;
import java.util.Stack;

public class DemoStack {
  public static void main(String[] args) {
    // Last-in, First-out
    Stack<String> ss = new Stack<>();
    ss.add("hello");
    ss.push("world");
    ss.push("abc");
    ss.add("def");
    System.out.println(ss); // [hello, world, abc, def]
    System.out.println(ss.pop()); // def, remove and return the last element
    System.out.println(ss.pop()); // abc

    ss.push("bbb");
    System.out.println(ss); // [hello, world, bbb]

    List<String> ss2 = new Stack<>();
    // ss2.push();
    // ss2.poll();
    ss2.add("hello");
    ss2.add("abc");
    ss2.remove("abc");
    System.out.println(ss2); // [hello]
  }
}
