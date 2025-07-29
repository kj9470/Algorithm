import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
x = int(input())
sum = 0
start = 0
end = n - 1
count = 0

arr.sort()

while start < end:
    sum = arr[start] + arr[end]
    if sum == x:
        count += 1
    if sum <= x:
        start += 1
    else:
        end -= 1
print(count)