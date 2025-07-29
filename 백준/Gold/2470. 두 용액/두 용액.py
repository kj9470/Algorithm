import sys

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
sum = 0
start = 0
end = N - 1
closest_diff = float('inf')
resultA = 0
resultB = 0

arr.sort()

while start < end:
    sum = arr[start] + arr[end]

    if sum == 0:
        resultA = arr[start]
        resultB = arr[end]
        break

    if closest_diff > abs(sum):
        resultA = arr[start]
        resultB = arr[end]
        closest_diff = abs(sum)

    if sum <= 0:
        start += 1
    else:
        end -= 1

print(resultA, resultB)