import sys
input = sys.stdin.readline

N, M = map(int, input().split())
fields = [] * N
visited = [[False] * M for _ in range(N)]
col_move = [[-1, 0], [1, 0]]
row_move = [[0, 1], [0, -1]]
count = 0

for _ in range(N):
    fields.append(list(map(str, input().strip())))

def dfs(x, y, floor):
    visited[x][y] = True
    if floor == '|':
        for dx, dy in col_move:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and floor == fields[nx][ny]:
                    visited[nx][ny] = True
                    dfs(nx, ny, floor)
    else:
        for dx, dy in row_move:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and floor == fields[nx][ny]:
                    visited[nx][ny] = True
                    dfs(nx, ny, floor)

for x in range(N):
    for y in range(M):
        if not visited[x][y]:
            dfs(x, y, fields[x][y])
            count += 1

print(count)