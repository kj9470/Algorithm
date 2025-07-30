import sys
from itertools import combinations

input = sys.stdin.readline
N, C = map(int, input().split())
seq = list(map(int, input().split()))
count = 0
A = seq[:N // 2]
B = seq[N // 2:]

def get_subsets(seq):
    result = []
    n = len(seq)
    for r in range(n + 1):
        for comb in combinations(seq, r):
            result.append(sum(comb))
    return result

left = get_subsets(A)
right = get_subsets(B)
left.sort()
right.sort()
start = 0
end = len(right) - 1

while start < len(left) and end >= 0:
    if left[start] + right[end] <= C:
        count += end + 1
        start += 1
    else:
        end -= 1

print(count)