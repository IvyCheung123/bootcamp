import shape.Circle;

public class Box<T> { // <T> just like 未知 & any Type
  private T value;

  public Box() {

  }

  public Box(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  // <T> declared in static method has NO relationship to T declared in attribute
  public static <T> Box<T> createBox(T value) {
    return new Box<T>(value);
  }

  public static void main(String[] args) {
    // Define the type <T> in main
    Box<Integer> integerBox = new Box<>();
    integerBox.setValue(1); // autoboxing, int value -> Integer object

    Box<Customer> customerBox = new Box<>();
    customerBox.setValue(new Customer(30, "Alan"));

    // You cannot ...
    // Box<T> tBox = new Box<>();

    Box<String> strBox = Box.createBox("hello");
    Box<Circle> circleBox = Box.createBox(new Circle(1.0d));
  }
}
