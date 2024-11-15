N = int(input())
arr = [[ 0 for _ in range(1001) ] for _ in range(1001) ]

for n in range(N):
    x, y, width, height = map(int, input().split())
    for i in range(x, x + width, 1):
        for j in range(y, y + height, 1):
            arr[i][j] = n + 1

for i in range(N):
    print(sum(row.count(i + 1) for row in arr))