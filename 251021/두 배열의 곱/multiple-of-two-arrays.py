A = []
B = []

for _ in range(3):
    A.append(list(map(int, input().split())))

input()

for _ in range(3):
    B.append(list(map(int, input().split())))

for i in range(3):
    for j in range(3):
        print(A[i][j] * B[i][j], end=' ')
    print()