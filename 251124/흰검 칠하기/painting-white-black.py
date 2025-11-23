n = int(input())
MAX_N = 100000
arr = [0 for _ in range(2 * MAX_N + 1)]
arr_w = [0] * (2 * MAX_N + 1)
arr_b = [0] * (2 * MAX_N + 1)
idx = MAX_N

for _ in range(n):
    x, d = tuple(input().split())
    x = int(x)
    if d == 'L':
        while x > 0:
            arr[idx] = 1
            arr_w[idx] += 1
            x -= 1

            if x:
                idx -= 1
    else:
        while x > 0:
            arr[idx] = 2
            arr_b[idx] += 1
            x -= 1

            if x:
                idx += 1

b, w, g = 0, 0, 0
for i in range(2 * MAX_N + 1):
    if arr_w[i] >= 2 and arr_b[i] >= 2:
        g += 1
    elif arr[i] == 1:
        w += 1
    elif arr[i] == 2:
        b += 1

print(w, b, g)