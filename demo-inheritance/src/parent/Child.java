package parent;

public class Child extends Father {
  
  // implicitly empty constructor
  public Child() {
    // super(); // 寫唔寫都一樣
    super("John");
  }

  public static void main(String[] args) {
    Child c = new Child();
    Father f = new Father();
    Father f2 = new Child();
    // Child c2 = new Father();
    // not allowed, parent object cannot be assigned to child reference type

  }
}
