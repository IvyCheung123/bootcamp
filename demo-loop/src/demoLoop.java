public class demoLoop {
    public static void main(String[] args) {
        int x = 3;
        x *= 3; // 9
        x *= 3; // 27
        x *= 3; // 81

        // for loop
        // initialization (variable declaration & assignment) ; continous criteria ; incremental operation
        // Step 1: int i = 0
        // Step 2: check if i < 4 ? Yes
        // Step 3: print "hello"
        // Step 4: i++ -> 1
        // ...
        // i = 4 < 4 ? No
        // No print
        // exit the loop
        for (int i = 0; i < 4; i++) { // 0,1,2,3
            System.out.println("hello");
        }
        // hello
        // hello
        // hello
        // hello

        int y = 3;
        for (int i = 0; i < 3; i++) {
            y *= 3;
        }
        System.out.println("y = " + y); // y = 81

        // 2
        // 4
        // 6
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.println(i);
            }
        }

        System.out.println("\nBelow is sum = 55: ");
        // 1 + 2 + 3 + 4 + 5 ... 10
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum); // sum = 55

        // 2 + 4 + 6 + 8 = 20
        int sum2 = 0;
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                sum2 += i;
                System.out.println("sum2 = " + sum2);
            }
        }

        // 8
        // 6
        // 4
        // 2
        for (int i = 9; i > 0; i--) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        // break
        for (int i = 0; i < 10; i++) {
            if (i > 7) {
                break; // exit loop
            }
            System.out.println(i); // main logic
        } // 0 1 2 3 4 5 6 7

        // continue
        int total = 0;
        for (int i = 0; i < 5; i++) {
            if (i > 3) {
                continue; // when i = 4, skip "total += i", go to "i++"
            }
            total += i;
        }
        System.out.println("total = " + total);
    }
}
