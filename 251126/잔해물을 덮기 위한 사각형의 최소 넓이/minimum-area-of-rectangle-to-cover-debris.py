x1, y1, x2, y2 = [0] * 2, [0] * 2, [0] * 2, [0] * 2
x1[0], y1[0], x2[0], y2[0] = map(int, input().split())
x1[1], y1[1], x2[1], y2[1] = map(int, input().split())

OFFSET = 1000
arr = [[0] * (OFFSET * 2 + 1) for _ in range(OFFSET * 2 + 1)]

for i in range(x1[0], x2[0]):
    for j in range(y1[0], y2[0]):
        arr[i + OFFSET][j + OFFSET] = 1

for i in range(x1[1], x2[1]):
    for j in range(y1[1], y2[1]):
        arr[i + OFFSET][j + OFFSET] = 2

min_x = OFFSET * 2 + 1
max_x = -1
min_y = OFFSET * 2 + 1
max_y = -1

for x in range(len(arr)):
    for y in range(len(arr)):
        if arr[x][y] == 1:
            if min_x > x:
                min_x = x
            if max_x < x:
                max_x = x
            if min_y > y:
                min_y = y
            if max_y < y:
                max_y = y

count = 0
for x in range(min_x, max_x + 1):
    for y in range(min_y, max_y + 1):
        count += 1

print(count)