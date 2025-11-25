n = int(input())
OFFSET = 100
arr = [[0] * (2 * OFFSET + 1) for _ in range(OFFSET + 1)]

for _ in range(n):
    a, b, c, d = map(int, input().split())
    for i in range(a, c):
        for j in range(b, d):
            arr[i][j] = 1

count = 0
for i in range(len(arr)):
    for j in range(len(arr)):
        if arr[i][j] == 1:
            count += 1

print(count)