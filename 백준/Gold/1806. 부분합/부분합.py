import sys

input = sys.stdin.readline
N, S = map(int, input().split())
seq = list(map(int, input().split()))

end = 0
min_count = float('inf')
count = 0
sum = 0

for start in range(N):
    while sum < S and end < N:
        if sum < S:
            sum += seq[end]
            end += 1
            count += 1
    if sum >= S and count < min_count:
        min_count = count
    sum -= seq[start]
    count -= 1

if min_count == float('inf'):
    print(0)
else:
    print(min_count)