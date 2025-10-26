n = int(input())
arr = list(map(int, input().split()))

def check(n, arr):
    for i in range(len(arr)):
        num = arr[i]
        if num % 2 == 0:
            arr[i] = num // 2
    print(*arr)

check(n, arr)