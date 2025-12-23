n, m = map(int, input().split())
arr = [[0] * m for _ in range(n)]

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

x, y = 0, 0
arr[x][y] = 1

move = 0
num = 2

while num <= n * m:
    nx, ny = x + dr[move], y + dc[move]
    if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 0:
        x, y = nx, ny
        arr[x][y] = num
        num += 1
    else:
        if move + 1 > 3:
            move = 0
        else:
            move += 1

for x in range(n):
    for y in range(m):
        print(arr[x][y], end=' ')
    print()