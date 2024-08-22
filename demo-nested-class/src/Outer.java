import java.util.LinkedList;
import java.util.List;

public class Outer {
  private List<Inner> classes;
  public String outerAttribute; // public to Inner.class

  public Outer() {
    this.classes = new LinkedList<>();
  }

  public void add(Inner c) {
    this.classes.add(c);
  }

  public static class Inner extends Outer{
    private static int number = 0;
    private int classNo;

    public Inner() {
      this.classNo = ++number;
    }

    public int getClassNo() {
      return this.classNo;
    }

    public static int getInnerStaticMethod() {
      return -1;
    }

    public void setOuterAttribute(String outer) {
      // Inner.class does not extends Outer.class -> cannot access outerAttribute
      this.outerAttribute = outer; // public + extends
    }

    public String getOuterAttribute() {
      return this.outerAttribute; // public + extends
    }
  }

  public static void main(String[] args) {
    // Outer outer = new Outer();
    // Static Nested Class can be called by Outer.Inner
    Outer.Inner inner = new Outer.Inner();
    System.out.println(inner.getClassNo()); // 1
    System.out.println(Inner.getInnerStaticMethod()); // -1
  }
}
