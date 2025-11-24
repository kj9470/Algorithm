n = int(input())
commands = [tuple(input().split()) for _ in range(n)]
x = []
dir = []
for num, direction in commands:
    x.append(int(num))
    dir.append(direction)

MAX_N = 100000
arr = [0] * (2 * MAX_N + 1)
idx = MAX_N

for x, d in commands:
    x = int(x)
    if d == 'L':
        for _ in range(x):
            idx -= 1
            arr[idx] = 1
    else:
        for _ in range(x):
            arr[idx] = 2
            idx += 1

w, b = 0, 0
for i in range(len(arr)):
    if arr[i] == 1:
        w += 1
    elif arr[i] == 2:
        b += 1

print(w, b)