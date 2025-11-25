n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x, y = zip(*points)
x, y = list(x), list(y)

OFFSET = 100
arr = [[0] * (OFFSET * 2 + 1) for _ in range(OFFSET * 2 + 1)]

for x, y in points:
    for i in range(x, x + 8):
        for j in range(y, y + 8):
            arr[i][j] = 1

count = 0
for i in range(len(arr)):
    for j in range(len(arr)):
        if arr[i][j] == 1:
            count += 1

print(count)