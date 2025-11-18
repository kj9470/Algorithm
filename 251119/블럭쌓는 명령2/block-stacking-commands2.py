n, k = map(int, input().split())
commands = [tuple(map(int, input().split())) for _ in range(k)]

blocks = [0 for _ in range(n + 1)]
for s, e in commands:
    for i in range(s, e + 1):
        blocks[i] += 1

print(max(blocks))