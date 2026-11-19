import java.util.*;

public class QuickSort {
    static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    static void sort(int a[], int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            sort(a, low, p - 1);
            sort(a, p + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        long start = System.nanoTime();
        sort(a, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("Sorted Array: " + Arrays.toString(a));
        System.out.println("Average Time Complexity: O(n log n)");
        System.out.println("Worst Time Complexity: O(n^2)");
        System.out.println("Average Space Complexity: O(log n)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }

  Output:
  Enter number of elements: 6
Enter elements:
10 7 8 9 1 5
Sorted Array: [1, 5, 7, 8, 9, 10]
Average Time Complexity: O(n log n)
Worst Time Complexity: O(n^2)
Average Space Complexity: O(log n)
Execution Time: [varies] ns
}
