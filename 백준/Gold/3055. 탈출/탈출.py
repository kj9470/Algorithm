import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().split())
board = []
water = deque([])
sx, sy = 0, 0
ex, ey = 0, 0

for i in range(R):
    row = list(input().strip())
    for j in range(C):
        if row[j] == '*':
            water.append((i, j))
        elif row[j] == 'S':
            sx, sy = i, j
    board.append(row)

queue = deque([(sx, sy, 0)])
visited = [[False] * C for _ in range(R)]
visited[sx][sy] = True
move = [[1, 0], [-1, 0], [0, -1], [0, 1]]

while queue:
    for _ in range(len(water)):
        x, y = water.popleft()
        for dx, dy in move:
            nx, ny = dx + x, dy + y
            if 0 <= nx < R and 0 <= ny < C:
                if board[nx][ny] == '.':
                    board[nx][ny] = '*'
                    water.append((nx, ny))

    for _ in range(len(queue)):
        x, y, day = queue.popleft()
        for dx, dy in move:
            nx, ny = dx + x, dy + y
            if 0 <= nx < R and 0 <= ny < C:
                if not visited[nx][ny]:
                    if board[nx][ny] == 'D':
                        print(day + 1)
                        exit()
                    if board[nx][ny] == '.':
                        visited[nx][ny] = True
                        queue.append((nx, ny, day + 1))

print("KAKTUS")