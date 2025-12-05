n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]
result = 0

for x in range(n):
    for y in range(n):
        count = 0
        for i, j in zip(dx, dy):
            nx, ny = x + i, y + j
            if 0 <= nx < n and 0 <= ny < n:
                if grid[nx][ny] == 1:
                    count += 1
        if count >= 3:
            result += 1

print(result)