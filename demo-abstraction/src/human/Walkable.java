package human;

// Contract, Behavior
public interface Walkable {
  // Interface
  // 1. No instance (private) variable
  // 2. All methods are public abstract implicitly
  // 3. You can still declare public static final implicitly
  // 4. A class can implements more than one interface, but it can only extend one Parent class

  // public static final int AGE = 3;
  // Constant
  int AGE = 3;

  // public abstract void walk();
  void walk();
  
  // After Java 8, we have default method and static method in interface
  // Backward Compatibility
  // Can be overrided
  // No influence in Human.class if Human cannot run
  default void run() {
    System.out.println("I'm running.");
  }

  static void swim() {
    System.out.println("I'm swimming.");
  }

  // default 用黎inherit, 但static跟class, 唔係用黎inherit
  // default static void read() {
  //   System.out.println("I'm reading.");
  // }
  // Compile error
  // Illegal combination of modifiers for the interface method read; only one of abstract, default, or static permitted
}
