import time

s1 = input("Enter first string: ")
s2 = input("Enter second string: ")

m = len(s1)
n = len(s2)

start = time.perf_counter_ns()

dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

for i in range(1, m + 1):
    for j in range(1, n + 1):
        if s1[i - 1] == s2[j - 1]:
            dp[i][j] = 1 + dp[i - 1][j - 1]
        else:
            dp[i][j] = max(
                dp[i - 1][j],
                dp[i][j - 1]
            )

i, j = m, n
lcs = []

while i > 0 and j > 0:
    if s1[i - 1] == s2[j - 1]:
        lcs.append(s1[i - 1])
        i -= 1
        j -= 1
    elif dp[i - 1][j] > dp[i][j - 1]:
        i -= 1
    else:
        j -= 1

lcs.reverse()

end = time.perf_counter_ns()

print("LCS:", "".join(lcs))
print("LCS Length:", dp[m][n])
print("Time Complexity: O(m*n)")
print("Space Complexity: O(m*n)")
print("Execution Time:", end - start, "ns")

Output:
Enter first string: AGGTAB
Enter second string: GXTXAYB
LCS: GTAB
LCS Length: 4
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Execution Time: [varies] ns
