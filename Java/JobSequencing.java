import java.util.*;

public class JobSequencing {
    static class Job {
        int id, deadline, profit;

        Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job jobs[] = new Job[n];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter deadline and profit for job " + (i + 1) + ": ");
            int d = sc.nextInt();
            int p = sc.nextInt();

            jobs[i] = new Job(i + 1, d, p);
            maxDeadline = Math.max(maxDeadline, d);
        }

        long start = System.nanoTime();

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int slots[] = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = Math.min(job.deadline, maxDeadline); j >= 1; j--) {
                if (slots[j] == -1) {
                    slots[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        long end = System.nanoTime();

        System.out.print("Selected Jobs: ");

        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i] != -1)
                System.out.print("J" + slots[i] + " ");
        }

        System.out.println("\nMaximum Profit: " + totalProfit);
        System.out.println("Time Complexity: O(n log n + nD)");
        System.out.println("Space Complexity: O(D)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}

Output:
Enter number of jobs: 5
Enter deadline and profit for job 1: 2 100
Enter deadline and profit for job 2: 1 19
Enter deadline and profit for job 3: 2 27
Enter deadline and profit for job 4: 1 25
Enter deadline and profit for job 5: 3 15
Selected Jobs: J3 J1 J5
Maximum Profit: 142
Time Complexity: O(n log n + nD)
Space Complexity: O(D)
Execution Time: [varies] ns
