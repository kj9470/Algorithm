n = int(input())
arr = list(map(int, input().split()))

def absolute_value(arr):
    for i in range(n):
        if arr[i] < 0:
            arr[i] = abs(arr[i])

absolute_value(arr)
print(*arr)