package shape3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Shape3 {
  abstract double area();

  public Shape3() {
    // new Shape3 object
  }

  // Approach 1: Parent class
  public static double area(List<Shape3> shapes) {
    BigDecimal bd = BigDecimal.valueOf(0.0);
    for (Shape3 s : shapes) {
      bd = bd.add(BigDecimal.valueOf(s.area()));
    }
    return bd.doubleValue();
  }

  // Approach 2: Generics
  // <T extends Shape3> is to describe the parent relationship
  public static <T extends Shape3> double area2(List<T> shapes) {
    BigDecimal bd = BigDecimal.valueOf(0.0);
    for (Shape3 s : shapes) {
      bd = bd.add(BigDecimal.valueOf(s.area()));
    }
    return bd.doubleValue();
  }

  // List<Object> vs List<T>?

  public static double area3(List<? extends Shape3> shapes) {
    return -3.0d;
  }

  public static double area4(List<? super Shape3> shapes) {
    return -3.0d;
  }

  public static void main(String[] args) {
    List<Shape3> shapes = new LinkedList<>();
    shapes.add(new Circle3(3.0));
    shapes.add(new Circle3(4.2));

    System.out.println(Shape3.area(shapes)); // 83.69202829163208
    System.out.println(Shape3.area2(shapes)); // 83.69202829163208

    // Shape vs Circle -> Parent vs Child
    // List<Shape vs Circle> -> NOT Parent
    // Error: List<Shape3> shapes = new LinkedList<Circle>();

    // <? extends Shape3> -> LinkedList<Shape3或以下>
    List<? extends Shape3> shapes2 = new LinkedList<>();
    shapes2 = new ArrayList<Square3>();
    // List<? extends Shape3> shapes2 = new LinkedList<>();
    // can be pointed to:
    // 1. LinkedList<Circle3> object
    // 2. LinkedList<Square> object
    // Compiler cannot ensure type safety (Circle? / Square?)

    // <? super Shape3> -> LinkedList<Shape3或以上>
    List<? super Shape3> shapes3 = new LinkedList<Object>();
    shapes3.add(new Circle3(3.0d)); // Circle3 extends Shape3
    shapes3.add(new Square3(3.0d)); // Square3 extends Shape3
    Object obj = shapes3;

    // shapes3 = new LinkedList<Shape3>();
    // shapes3.add(new Triangle3()); // Triangle3 NOT extends Shape3
    // so cannot add Triangle3 object, compiler will ban

    // List<Object> objects = new ArrayList<Circle3>(); // NOT Parent
    Object object = new Circle3(1.0d); // Parent
  }
}
