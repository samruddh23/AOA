import java.util.*;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        long start = System.nanoTime();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder lcs = new StringBuilder();

        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        long end = System.nanoTime();

        System.out.println("LCS: " + lcs.reverse());
        System.out.println("LCS Length: " + dp[m][n]);
        System.out.println("Time Complexity: O(m*n)");
        System.out.println("Space Complexity: O(m*n)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}

Output:
Enter first string: AGGTAB
Enter second string: GXTXAYB
LCS: GTAB
LCS Length: 4
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Execution Time: [varies] ns
