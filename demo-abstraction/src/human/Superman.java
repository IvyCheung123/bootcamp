package human;

public class Superman implements Walkable {
  @Override
  public void walk() {
    System.out.println("Superman is walking.");
  }

  @Override
  public void run() {
    System.out.println("Superman is running.");
  }

  public static void main(String[] args) {
    Superman sm = new Superman();
    sm.walk(); // Superman is walking.
    sm.run(); // Superman is running.
  }
}
