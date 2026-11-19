import time

def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if arr[j] < pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1


def quick_sort(arr, low, high):
    if low < high:
        p = partition(arr, low, high)
        quick_sort(arr, low, p - 1)
        quick_sort(arr, p + 1, high)


n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter elements: ").split()))

start = time.perf_counter_ns()
quick_sort(arr, 0, n - 1)
end = time.perf_counter_ns()

print("Sorted Array:", arr)
print("Average Time Complexity: O(n log n)")
print("Worst Time Complexity: O(n^2)")
print("Average Space Complexity: O(log n)")
print("Execution Time:", end - start, "ns")

Output:
Enter number of elements: 6
Enter elements: 10 7 8 9 1 5
Sorted Array: [1, 5, 7, 8, 9, 10]
Average Time Complexity: O(n log n)
Worst Time Complexity: O(n^2)
Average Space Complexity: O(log n)
Execution Time: [varies] ns
