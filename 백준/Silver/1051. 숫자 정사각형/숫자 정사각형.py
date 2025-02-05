N, M = map(int, input().split())

matrix = []
for i in range(N):
    matrix.append(list(map(int, input().strip())))

tmp = min(N, M)
flag = False

while tmp >= 1 and not flag:
    flag = False
    for i in range(N - tmp + 1):
        for j in range(M - tmp + 1):
            if(matrix[i][j] == matrix[i][j + tmp - 1] == matrix[i + tmp - 1][j] == matrix[i + tmp - 1][j + tmp - 1]):
                flag = True
                break

    if flag:
        print(tmp * tmp)
    else:
        tmp -= 1