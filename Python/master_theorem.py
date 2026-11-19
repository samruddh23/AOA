import time
import math

a, b, d = map(int, input("Enter a, b and d: ").split())

start = time.perf_counter_ns()

value = math.log(a, b)

print(f"Recurrence: T(n) = {a}T(n/{b}) + n^{d}")

if value > d:
    print("Case 1")
    print("Time Complexity: O(n^log_b(a))")
elif abs(value - d) < 0.0001:
    print("Case 2")
    print(f"Time Complexity: O(n^{d} log n)")
else:
    print("Case 3")
    print(f"Time Complexity: O(n^{d})")

end = time.perf_counter_ns()

print("Space Complexity: O(1)")
print("Execution Time:", end - start, "ns")

Output:
Enter a, b and d: 2 2 1
Recurrence: T(n) = 2T(n/2) + n^1
Case 2
Time Complexity: O(n^1 log n)
Space Complexity: O(1)
Execution Time: [varies] ns
