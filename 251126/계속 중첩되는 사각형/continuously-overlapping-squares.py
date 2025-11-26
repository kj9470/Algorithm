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

for idx in range(n):
    for i in range(x1[idx], x2[idx]):
        for j in range(y1[idx], y2[idx]):
            if idx % 2 == 0:
                arr[i][j] = 1
            else:
                arr[i][j] = 2

count = 0
for i in range(len(arr)):
    for j in range(len(arr)):
        if arr[i][j] == 2:
            count += 1

print(count)