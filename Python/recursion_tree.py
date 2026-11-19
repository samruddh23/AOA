import time

n = int(input("Enter n (power of 2): "))

start = time.perf_counter_ns()

levels = 0
temp = n

while temp > 1:
    temp //= 2
    levels += 1

total_cost = n * levels + n

end = time.perf_counter_ns()

print("Recurrence: T(n) = 2T(n/2) + n")
print("Number of levels:", levels)
print("Total cost:", total_cost)
print("Time Complexity: O(n log n)")
print("Space Complexity: O(1)")
print("Execution Time:", end - start, "ns")

Output:
Enter n (power of 2): 8
Recurrence: T(n) = 2T(n/2) + n
Number of levels: 3
Total cost: 32
Time Complexity: O(n log n)
Space Complexity: O(1)
Execution Time: [varies] ns
