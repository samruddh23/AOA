import java.util.*;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int weight[] = new int[n];
        int profit[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit and weight: ");
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter capacity: ");
        int W = sc.nextInt();

        long start = System.nanoTime();

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("Maximum Profit: " + dp[n][W]);
        System.out.println("Time Complexity: O(nW)");
        System.out.println("Space Complexity: O(nW)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}

Output:
Enter number of items: 3
Enter profit and weight: 60 10
Enter profit and weight: 100 20
Enter profit and weight: 120 30
Enter capacity: 50
Maximum Profit: 220
Time Complexity: O(nW)
Space Complexity: O(nW)
Execution Time: [varies] ns
