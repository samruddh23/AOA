import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int profit, weight;
        double ratio;

        Item(int p, int w) {
            profit = p;
            weight = w;
            ratio = (double) p / w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item items[] = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit and weight: ");
            int p = sc.nextInt();
            int w = sc.nextInt();
            items[i] = new Item(p, w);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        long start = System.nanoTime();

        Arrays.sort(items, (a, b) ->
            Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;

        for (Item item : items) {
            if (capacity == 0)
                break;

            if (item.weight <= capacity) {
                totalProfit += item.profit;
                capacity -= item.weight;
            } else {
                totalProfit += item.ratio * capacity;
                capacity = 0;
            }
        }

        long end = System.nanoTime();

        System.out.println("Maximum Profit: " + totalProfit);
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Space Complexity: O(n)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }

  Output:
  Enter number of items: 3
Enter profit and weight: 60 10
Enter profit and weight: 100 20
Enter profit and weight: 120 30
Enter knapsack capacity: 50
Maximum Profit: 240.0
Time Complexity: O(n log n)
Space Complexity: O(n)
Execution Time: [varies] ns
}
