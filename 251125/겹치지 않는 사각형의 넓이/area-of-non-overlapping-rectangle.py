x1 = [0] * 3
y1 = [0] * 3
x2 = [0] * 3
y2 = [0] * 3

x1[0], y1[0], x2[0], y2[0] = map(int, input().split())
x1[1], y1[1], x2[1], y2[1] = map(int, input().split())
x1[2], y1[2], x2[2], y2[2] = map(int, input().split())

OFFSET = 1000
arr = [[0] * (OFFSET * 2 + 1) for _ in range(OFFSET * 2 + 1)]

for k in range(3):
    for i in range(x1[k], x2[k]):
        for j in range(y1[k], y2[k]):
            if k == 2:
                arr[i][j] = 0
            else:
                arr[i][j] = 1

count = 0
for i in range(len(arr)):
    for j in range(len(arr)):
        if arr[i][j] == 1:
            count += 1

print(count)