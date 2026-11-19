import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        long start = System.nanoTime();

        int low = 0, high = n - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == key) {
                result = mid;
                break;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long end = System.nanoTime();

        if (result == -1)
            System.out.println("Element Not Found");
        else
            System.out.println("Element Found at index: " + result);

        System.out.println("Time Complexity: O(log n)");
        System.out.println("Space Complexity: O(1)");
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }

  Output:
  Enter number of elements: 6
Enter sorted elements:
10 20 30 40 50 60
Enter element to search: 40
Element Found at index: 3
Time Complexity: O(log n)
Space Complexity: O(1)
Execution Time: [varies] ns
}
