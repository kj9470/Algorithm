arr = list(input())
x, y = 0, 0

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
move = 0

for r in arr:
    if r == 'L':
        if move < 3:
            move += 1
        else:
            move = 0
    if r == 'R':
        if move > 0:
            move -= 1
        else:
            move = 3
    if r == 'F':
        x, y = x + dx[move], y + dy[move]

print(x, y)