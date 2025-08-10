from collections import deque
import sys

input = sys.stdin.readline
fields = [list(map(str, input().strip())) for _ in range(12)]

count = 0

def bfs(x, y):
    queue = deque([(x, y)])
    move = [[1, 0], [-1, 0], [0, -1], [0, 1]]
    visited[x][y] = True
    puyo_list.append((x, y))
    puyo_color = fields[x][y]

    while queue:
        x, y = queue.popleft()
        for dx, dy in move:
            nx, ny = x + dx, y + dy
            if 0 <= nx < 12 and 0 <= ny < 6:
                if not visited[nx][ny] and fields[nx][ny] == puyo_color:
                    puyo_list.append((nx, ny))
                    queue.append((nx, ny))
                    visited[nx][ny] = True


def bomb(puyo_list):
    for x, y in puyo_list:
        fields[x][y] = '.'

def down():
    for y in range(6):
        stack = []
        for x in range(12):
            if fields[x][y] != '.':
                stack.append(fields[x][y])

        for x in range(12):
            fields[x][y] = '.'

        row = 11
        while stack:
            block = stack.pop()
            fields[row][y] = block
            row -= 1

while True:
    visited = [[False] * 6 for _ in range(12)]
    bomb_list = []

    for x in range(12):
        for y in range(6):
            if fields[x][y] != '.' and not visited[x][y]:
                puyo_list = []
                bfs(x, y)
                if len(puyo_list) >= 4:
                    bomb_list.extend(puyo_list)

    if not bomb_list:
        break

    bomb(bomb_list)
    down()
    count += 1

print(count)