import sys
input = sys.stdin.readline

N, Z, M = map(int, input().split())

obstacle = list(map(int, input().split()))

for i in range(1, N):
    idx = 0
    for j in range(N):
        if idx + 1 in obstacle:
            break
        if idx + 1 == Z:
            print(i)
            exit()
        else:
            idx = (idx + i) % N
