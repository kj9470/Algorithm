import sys

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    n = int(input())
    arr = []
    for i in range(n):
        arr.append(list(map(int, input().split())))

    arr.sort()
    res = 1
    min = arr[0][1]
    for i in range(1, n):
        if min > arr[i][1]:
            res += 1
            min = arr[i][1]

    print(res)