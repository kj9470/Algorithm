n = int(input())
dir = []

for _ in range(n):
    xi, di = input().split()
    dir.append((int(xi), di))

check = [0 for _ in range(2000)]

idx = 1000
for x, d in dir:
    if d == 'L':
        for i in range(x):
            idx -= 1
            check[idx] += 1
    if d == 'R':
        for i in range(x):
            check[idx] += 1
            idx += 1

count = 0
for i in range(len(check)):
    if check[i] >= 2:
        count += 1

print(count)