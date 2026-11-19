import time

n = int(input("Enter number of items: "))

profit = []
weight = []

for i in range(n):
    p, w = map(int, input("Enter profit and weight: ").split())
    profit.append(p)
    weight.append(w)

W = int(input("Enter capacity: "))

start = time.perf_counter_ns()

dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    for w in range(W + 1):
        if weight[i - 1] <= w:
            dp[i][w] = max(
                profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                dp[i - 1][w]
            )
        else:
            dp[i][w] = dp[i - 1][w]

end = time.perf_counter_ns()

print("Maximum Profit:", dp[n][W])
print("Time Complexity: O(nW)")
print("Space Complexity: O(nW)")
print("Execution Time:", end - start, "ns")

Output:
Enter number of items: 3
Enter profit and weight: 60 10
Enter profit and weight: 100 20
Enter profit and weight: 120 30
Enter capacity: 50
Maximum Profit: 220
Time Complexity: O(nW)
Space Complexity: O(nW)
Execution Time: [varies] ns
