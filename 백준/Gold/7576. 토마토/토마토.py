import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
queue = deque()
day = 0

for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            queue.append((i, j, 0))

def bfs():
    move = [[1, 0], [-1, 0], [0, -1], [0, 1]]
    max_day = 0

    while queue:
        x, y, day = queue.popleft()
        visited[x][y] = True
        max_day = max(max_day, day)
        for dx, dy in move:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and box[nx][ny] == 0:
                    box[nx][ny] = 1
                    queue.append((nx, ny, day + 1))
                    visited[nx][ny] = True
    return max_day

result = bfs()

for row in box:
    if 0 in row:
        print(-1)
        break
else:
    print(result)