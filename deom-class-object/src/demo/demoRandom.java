package demo;

import java.util.Random;

public class demoRandom {

  // private final int baseSalary = 6000;
  private int baseSalary = 6000;

  public void setBaseSalary(int baseSalary) {
    this.baseSalary = baseSalary;
  }

  public int getSalary(int bonus) {
    return this.baseSalary + bonus;
  }

  public static void main(String[] args) {
    // JDK class
    // random -> usually get integer
    int random = new Random().nextInt(3); // 0-2
    System.out.println(random);
    int random2 = new Random().nextInt(3) + 1; // 1-3
    System.out.println(random2);
    int random3 = new Random().nextInt(3 - 1) + 1; // (0-1) + 1 -> 1-2
    System.out.println(random3);
    int random4 = new Random().nextInt(2) + 49; // (0-1) + 49 -> 49-50
    System.out.println(random4);
    char randomChar = (char) (new Random().nextInt(5) + 65); // (0-4) + 65 -> 65-69 -> A-E
    System.out.println(randomChar);

    demoRandom dr = new demoRandom();
    System.out.println(dr.getSalary(1)); // 6001
    dr.setBaseSalary(10000);
    System.out.println(dr.getSalary(1)); // 10001
  }

}
