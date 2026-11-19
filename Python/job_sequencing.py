import time

n = int(input("Enter number of jobs: "))

jobs = []

for i in range(n):
    deadline, profit = map(
        int, input("Enter deadline and profit: ").split()
    )
    jobs.append((i + 1, deadline, profit))

start = time.perf_counter_ns()

jobs.sort(key=lambda x: x[2], reverse=True)

max_deadline = max(job[1] for job in jobs)

slots = [None] * max_deadline
total_profit = 0

for job_id, deadline, profit in jobs:
    for j in range(min(deadline, max_deadline) - 1, -1, -1):
        if slots[j] is None:
            slots[j] = job_id
            total_profit += profit
            break

end = time.perf_counter_ns()

selected_jobs = ["J" + str(j) for j in slots if j is not None]

print("Selected Jobs:", selected_jobs)
print("Maximum Profit:", total_profit)
print("Time Complexity: O(n log n + nD)")
print("Space Complexity: O(D)")
print("Execution Time:", end - start, "ns")

Output:
Enter number of jobs: 5
Enter deadline and profit: 2 100
Enter deadline and profit: 1 19
Enter deadline and profit: 2 27
Enter deadline and profit: 1 25
Enter deadline and profit: 3 15
Selected Jobs: ['J3', 'J1', 'J5']
Maximum Profit: 142
Time Complexity: O(n log n + nD)
Space Complexity: O(D)
Execution Time: [varies] ns
