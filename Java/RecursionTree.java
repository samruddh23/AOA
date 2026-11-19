import java.util.Scanner;

public class RecursionTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (power of 2): ");
        int n = sc.nextInt();

        long start = System.nanoTime();

        int levels = 0, temp = n;

        while (temp > 1) {
            temp /= 2;
            levels++;
        }

        int totalCost = n * levels + n;

        long end = System.nanoTime();

        System.out.println("Recurrence: T(n) = 2T(n/2) + n");
        System.out.println("Number of levels: " + levels);
        System.out.println("Total cost: " + totalCost);
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Space Complexity: O(1)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}

Output:
Enter n (power of 2): 8
Recurrence: T(n) = 2T(n/2) + n
Number of levels: 3
Total cost: 32
Time Complexity: O(n log n)
Space Complexity: O(1)
Execution Time: [varies] ns
