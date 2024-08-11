public class Demo {
  public static void main(String[] args) {
    // Static Nested Class
    // Bank bank = new Bank();
    Bank.Account account = new Bank.Account(); // No create Bank object
    System.out.println(account.getAccountNo()); // 1

    // Inner Class (Non-static Nested Class)
    DemoBox box = new DemoBox();
    DemoBox.Ball ball = box.new Ball();
    System.out.println(ball.getCapacity()); // 0
    box.add(ball);
    System.out.println(box.getBalls().size()); // 1

    // Annoymous Inner Class
    int x = 0;
    if (x == 0) {
      Swimable alan = new Swimable() {
        @Override
        public void swim() {
          System.out.println("Alan is swimming.");
        }
      };
      alan.swim(); // Alan is swimming.
    } else if (x != 0) {
      Swimable ben = new Swimable() {
        public String name = "Ben";
  
        public String getName() {
          return this.name;
        }
  
        @Override
        public void swim() {
          System.out.println("Ben is swimming.");
        }
      };
      ben.swim(); // Ben is swimming.
      // ben.getName(); // Swimable does not have getName()
      // ben.name; // Interface cannot contain attributes
    }
  }
}
