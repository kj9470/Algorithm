from collections import deque

N = int(input())
map = [list(map(int, input().strip())) for _ in range(N)]
check = [[0 for _ in range(N)] for _ in range(N)]
v = []

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def BFS(x, y):
    q = deque()
    q.append([x, y])
    check[x][y] = 1
    count = 1

    while q:
        c = q.popleft()
        cx = c[0]
        cy = c[1]

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if nx >= 0 and ny >= 0 and nx < N and ny < N and check[nx][ny] == 0 and map[nx][ny] == 1:
                check[nx][ny] = 1
                q.append([nx, ny])
                count += 1
    return count

for i in range(N):
    for j in range(N):
        if not check[i][j] and map[i][j] == 1:
            v.append(BFS(i, j))
v.sort()
print(len(v))
for i in v:
    print(i)