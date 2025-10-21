N = int(input())
arr = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    cnt = 1
    if i % 2 == 0:
        for j in range(N):
            arr[j][i] = j + 1
    else:
        for j in range(N - 1, -1, -1):
            arr[j][i] = cnt
            cnt += 1

for i in range(N):
    for j in range(N):
        print(arr[i][j], end='')
    print()
