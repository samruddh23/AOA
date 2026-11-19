import time

n = int(input("Enter number of items: "))

items = []

for i in range(n):
    p, w = map(int, input("Enter profit and weight: ").split())
    items.append((p, w, p / w))

capacity = int(input("Enter knapsack capacity: "))

start = time.perf_counter_ns()

items.sort(key=lambda x: x[2], reverse=True)

total_profit = 0

for profit, weight, ratio in items:
    if capacity == 0:
        break

    if weight <= capacity:
        total_profit += profit
        capacity -= weight
    else:
        total_profit += ratio * capacity
        capacity = 0

end = time.perf_counter_ns()

print("Maximum Profit:", total_profit)
print("Time Complexity: O(n log n)")
print("Space Complexity: O(n)")
print("Execution Time:", end - start, "ns")

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
