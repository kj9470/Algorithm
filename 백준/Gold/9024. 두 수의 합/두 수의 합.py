import sys

input = sys.stdin.readline
t = int(input())

def find(K, arr):
    start = 0
    end = len(arr) - 1
    closest_diff = float('inf')
    count = 0

    while start < end:
        sum = arr[start] + arr[end]
        diff = abs(K - sum)

        if closest_diff > diff:
            count = 1
            closest_diff = diff
        elif closest_diff == diff:
            count += 1

        if sum < K:
            start += 1
        else:
            end -= 1

    return count

for i in range(t):
    n, K = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()
    print(find(K, arr))