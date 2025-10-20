N, M = map(int, input().split())

A, B = [], []

for _ in range(N):
    A.append(list(map(int, input().split())))

for _ in range(N):
    B.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        if A[i][j] == B[i][j]:
            print(0, end=' ')
        else:
            print(1, end=' ')
    print()