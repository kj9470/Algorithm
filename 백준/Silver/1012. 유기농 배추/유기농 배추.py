from collections import deque

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    farm = [[0] * N for _ in range(M)]
    for _ in range(K):
        x, y = map(int, input().split())
        farm[x][y] = 1

    visited = [[False] * N for _ in range(M)]
    count = 0

    def bfs(sy, sx):
        move = [[1, 0], [-1, 0], [0, -1], [0, 1]]
        queue = deque([(sy, sx)])
        visited[sy][sx] = True

        while queue:
            y, x = queue.popleft()
            for dy, dx in move:
                ny, nx = y + dy, x + dx
                if 0 <= ny < M and 0 <= nx < N:
                    if farm[ny][nx] == 1 and not visited[ny][nx]:
                        queue.append((ny, nx))
                        visited[ny][nx] = True

    for y in range(M):
        for x in range(N):
            if farm[y][x] == 1 and not visited[y][x]:
                bfs(y, x)
                count += 1

    print(count)