import sys
input = sys.stdin.readline

N, Z, M = map(int, input().split())

obstacle = list(map(int, input().split()))

minIdx = N + 1

found = False

for i in range(1, N):
    if found:
        break
    idx = 0
    for j in range(N):
        if idx + 1 in obstacle:
            break
        if idx + 1 == Z:
            found = True
            minIdx = i
            break
        else:
            idx = (idx + i) % N

print(minIdx)

