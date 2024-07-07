package human;

public class Human extends SuperHuman implements Walkable, Readable {
  
  // Class can only inherit instance methods, instance variables
  // Constructor cannot be inherited

  public Human() {

  }

  public Human(double height) {
    super(height);
  }

  @Override
  public void walk() {
    System.out.println("Human is walking.");
  }

  @Override
  public void read() {
    System.out.println("Human is reading.");
  }

  // @Override
  // public double getHeight() {
  //   return super.getHeight();
  // }

  public static void main(String[] args) {
    System.out.println(Walkable.AGE); // 3, public static final

    Human h1 = new Human();
    h1.walk(); // Human is walking.
    h1.run(); // I'm running.
    Walkable.swim(); // I'm swimming.
  }
}
