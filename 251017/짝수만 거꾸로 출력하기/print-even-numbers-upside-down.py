N = int(input())
arr = list(map(int, input().split()))

arr.reverse()

for n in arr:
    if n % 2 == 0:
        print(n, end=' ')