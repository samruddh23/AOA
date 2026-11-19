import java.util.Scanner;

public class MasterTheorem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a, b and d: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        long start = System.nanoTime();

        double value = Math.log(a) / Math.log(b);

        System.out.println("Recurrence: T(n) = " + a + "T(n/" + b + ") + n^" + d);

        if (value > d) {
            System.out.println("Case 1");
            System.out.println("Time Complexity: O(n^log_b(a))");
        } else if (Math.abs(value - d) < 0.0001) {
            System.out.println("Case 2");
            System.out.println("Time Complexity: O(n^" + d + " log n)");
        } else {
            System.out.println("Case 3");
            System.out.println("Time Complexity: O(n^" + d + ")");
        }

        long end = System.nanoTime();

        System.out.println("Space Complexity: O(1)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}

Output:
Enter a, b and d: 2 2 1
Recurrence: T(n) = 2T(n/2) + n^1
Case 2
Time Complexity: O(n^1 log n)
Space Complexity: O(1)
Execution Time: [varies] ns
