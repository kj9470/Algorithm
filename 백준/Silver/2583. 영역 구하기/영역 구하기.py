import sys
from collections import deque

input = sys.stdin.readline

M, N, K = map(int, input().split())

paper = [[True] * M for _ in range(N)]
visited = [[False] * M for _ in range(N)]
count = 0
result = []

for _ in range(K):
    x, y, nx, ny = map(int, input().split())
    for i in range(x, nx):
        for j in range(y, ny):
            paper[i][j] = False


def bfs(x, y, visited):
    queue = deque([(x, y)])
    visited[x][y] = True
    move = [[1, 0], [-1, 0], [0, -1], [0, 1]]
    return_count = 1

    while queue:
        x, y = queue.popleft()
        for dx, dy in move:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and paper[nx][ny]:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    return_count += 1
    return return_count

for i in range(N):
    for j in range(M):
        if paper[i][j] and not visited[i][j]:
            result.append(bfs(i, j, visited))
            count += 1

result.sort()
print(count)
print(*result)