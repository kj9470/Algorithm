N = int(input())
map = [list(map(int, input().split())) for _ in range(N)]
max_n = max((max(n)) for n in map)
result = 0

def bfs(y, x, i, visited):
    queue = []
    queue.append((y, x))
    move = [[1, 0], [-1, 0], [0, -1], [0, 1]]
    visited[y][x] = True

    while queue:
        y, x = queue.pop(0)
        for dy, dx in move:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < N:
                if not visited[ny][nx] and map[ny][nx] > i:
                    queue.append((ny, nx))
                    visited[ny][nx] = True

for n in range(max_n):
    visited = [[False] * N for _ in range(N)]
    count = 0

    for y in range(N):
        for x in range(N):
            if map[y][x] > n and not visited[y][x]:
                bfs(y, x, n, visited)
                count += 1
    if result < count:
        result = count

print(result)