n = int(input())
x1, y1, x2, y2 = [], [], [], []
for _ in range(n):
    a, b, c, d = map(int, input().split())
    x1.append(a)
    y1.append(b)
    x2.append(c)
    y2.append(d)

OFFSET = 100
arr = [[0] * (OFFSET * 2 + 1) for _ in range(OFFSET * 2 + 1)]

for i in range(x1[0], x2[0]):
    for j in range(y1[0], y2[0]):
        arr[i + OFFSET][j + OFFSET] = 1

for i in range(x1[1], x2[1]):
    for j in range(y1[1], y2[1]):
        arr[i + OFFSET][j + OFFSET] = 2

count = 0
for i in range(len(arr)):
    for j in range(len(arr)):
        if arr[i][j] == 2:
            count += 1

print(count)