from collections import deque

N, M = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(N)]

def bfs(y, x):
    queue = deque([(y, x, 1)])
    move = [[1, 0], [-1, 0], [0, -1], [0, 1]]
    visited = [[False] * M for _ in range(N)]
    visited[y][x] = True

    while queue:
        y, x, count = queue.popleft()
        for dy, dx in move:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M:
                if maze[ny][nx] == 1 and not visited[ny][nx]:
                    if ny == N - 1 and nx == M - 1:
                        return count + 1
                    else:
                        queue.append((ny, nx, count + 1))
                        visited[ny][nx] = True

result = bfs(0, 0)
print(result)