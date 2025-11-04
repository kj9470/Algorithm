n = int(input())
arr = list(map(int, input().split()))

def recursion(i, j):
    if j == n:
        return i
    if arr[i] > arr[j]:
        return recursion(i, j + 1)
    else:
        return recursion(j, j + 1)

print(arr[recursion(0, 1)])