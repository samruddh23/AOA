import time

n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter sorted elements: ").split()))
key = int(input("Enter element to search: "))

start = time.perf_counter_ns()

low = 0
high = n - 1
result = -1

while low <= high:
    mid = (low + high) // 2

    if arr[mid] == key:
        result = mid
        break
    elif arr[mid] < key:
        low = mid + 1
    else:
        high = mid - 1

end = time.perf_counter_ns()

if result == -1:
    print("Element Not Found")
else:
    print("Element Found at index:", result)

print("Time Complexity: O(log n)")
print("Space Complexity: O(1)")
print("Execution Time:", end - start, "ns")

Output:
Enter number of elements: 6
Enter sorted elements: 10 20 30 40 50 60
Enter element to search: 40
Element Found at index: 3
Time Complexity: O(log n)
Space Complexity: O(1)
Execution Time: [varies] ns
