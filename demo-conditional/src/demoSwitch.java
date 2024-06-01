import java.util.Scanner;

public class demoSwitch {
  public static void main(String[] args) {
    char grade = 'B';
    switch (grade) {
      case 'A':
        System.out.println("The grade is " + grade);
        break; // break the whole statement
      case 'B':
        System.out.println("The grade is " + grade);
        break;
      case 'C': 
        System.out.println("The grade is " + grade);
        break;
      default:
        System.out.println("No grade");
    }

    if (grade == 'A' || grade == 'B' || grade == 'C') {
      System.out.println("The grade is " + grade);
    } else {
      System.out.println("No grade");
    }

    // accumulation
    int x = 0;
    switch (grade) {
      case 'A':
        x += 10;
      case 'B':
        x += 10;
      case 'C':
        x += 20;
      default:
        x += 30;
    }
    System.out.println(x); // grade 'B', print 0 + 10 + 20 + 30 = 60

    // Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Please input a number: ");
    int month = input.nextInt(); // line of input -> int
    System.out.println("month = " + month);
    input.close();
  }
}
