public class Demo {
  public static void main(String[] args) {
    // Static Nested Class
    // Bank bank = new Bank();
    Bank.Account account = new Bank.Account(); // No create Bank object
    System.out.println(account.getAccountNo()); // 1

    System.out.println();
    // Inner Class (Non-static Nested Class)
    DemoBox box = new DemoBox();
    DemoBox.Ball ball = box.new Ball();
    ball.setValue(100);
    System.out.println(ball.getValue()); // 100
    box.add(ball);
    System.out.println(box.getBalls().size()); // 1

    // Annoymous Inner Class
    int age = 10;
    if (age < 10) {
      Swimable p1 = new Swimable() {
        private String name = "Baby";
        @Override
        public void swim() {
          System.out.println(this.name + " can't swim yet");
        }
      };
      p1.swim(); // Baby can't swim yet
    } else if (age >= 10) {
      Swimable p2 = new Swimable() {
        public String name = "Children";
  
        public String getName() {
          return this.name;
        }
  
        @Override
        public void swim() {
          System.out.println(this.name + " is swimming.");
        }
      };
      p2.swim(); // Children is swimming
      // p2.getName(); // Swimable does not have getName()
      // p2.name; // Interface cannot contain attributes
    }
  }
}
