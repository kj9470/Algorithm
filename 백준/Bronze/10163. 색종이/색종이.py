N = int(input())
arr = [[ 0 for _ in range(1001) ] for _ in range(1001) ]

for n in range(N):
    x, y, width, height = map(int, input().split())
    for i in range(x, x + width):
        for j in range(y, y + height):
            arr[i][j] = n + 1

count = 0
for i in range(N):
    for j in range(len(arr)):
        count += arr[j].count(i + 1)
    print(count)
    count = 0