import sys

input = sys.stdin.readline
N, M = map(int, input().split())
chess = []
res = []
for _ in range(N):
    chess.append(input().strip())


for i in range(N-7):
    for j in range(M-7):
        t1 = 0
        t2 = 0

        for a in range(i, i+8):
            for b in range(j, j+8):
                if (a + b) % 2 == 0:
                    if chess[a][b] != 'B':
                        t1 += 1
                    if chess[a][b] != 'W':
                        t2 += 1
                else:
                    if chess[a][b] != 'W':
                        t1 += 1
                    if chess[a][b] != 'B':
                        t2 += 1

        res.append(t1)
        res.append(t2)

print(min(res))