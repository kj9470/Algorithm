n = int(input())
moves = [tuple(input().split()) for _ in range(n)]

dx, dy = [1, -1, 0, 0], [0, 0, -1, 1]
nx, ny = 0, 0
for dir, dist in moves:
    dir = str(dir)
    dist = int(dist)
    if dir == 'E':
        nx, ny = nx + (dx[0] * dist), ny + dy[0]
    if dir == 'W':
        nx, ny = nx + (dx[1] * dist), ny + dy[1]
    if dir == 'S':
        nx, ny = nx + dx[2], ny + (dy[2] * dist)
    if dir == 'N':
        nx, ny = nx + dx[3], ny + (dy[3] * dist)

print(nx, ny)