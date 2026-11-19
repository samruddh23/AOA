import java.util.*;

public class MergeSort {
    static void merge(int a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = a[l + i];

        for (int j = 0; j < n2; j++)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }

        while (i < n1)
            a[k++] = L[i++];

        while (j < n2)
            a[k++] = R[j++];
    }

    static void sort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
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
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Space Complexity: O(n)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }

  Output:
  Enter number of elements: 7
Enter elements:
38 27 43 3 9 82 10
Sorted Array: [3, 9, 10, 27, 38, 43, 82]
Time Complexity: O(n log n)
Space Complexity: O(n)
Execution Time: [varies] ns
}
