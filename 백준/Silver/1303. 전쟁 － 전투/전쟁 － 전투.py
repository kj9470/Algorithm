import sys
input = sys.stdin.readline

N, M = map(int, input().split())
fields = [] * (M + 1)
visited = [[False] * N for _ in range(M)]
move = [[1, 0], [-1, 0], [0, -1], [0, 1]]
w_total = 0
b_total = 0

for i in range(M):
    fields.append(list(map(str, input().strip())))

def dfs(y, x, color):
    count = 1
    for dx, dy in move:
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < M:
            if not visited[ny][nx] and fields[ny][nx] == color:
                visited[ny][nx] = True
                count += dfs(ny, nx, color)
    return count

for y in range(M):
    for x in range(N):
        if not visited[y][x]:
            visited[y][x] = True
            color = fields[y][x]
            count = dfs(y, x, color)
            if color == 'W':
                w_total += (count * count)
            else:
                b_total += (count * count)

print(w_total)
print(b_total)