import time

def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2

        left = arr[:mid]
        right = arr[mid:]

        merge_sort(left)
        merge_sort(right)

        i = j = k = 0

        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1


n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter elements: ").split()))

start = time.perf_counter_ns()
merge_sort(arr)
end = time.perf_counter_ns()

print("Sorted Array:", arr)
print("Time Complexity: O(n log n)")
print("Space Complexity: O(n)")
print("Execution Time:", end - start, "ns")

Output:
Enter number of elements: 7
Enter elements: 38 27 43 3 9 82 10
Sorted Array: [3, 9, 10, 27, 38, 43, 82]
Time Complexity: O(n log n)
Space Complexity: O(n)
Execution Time: [varies] ns
