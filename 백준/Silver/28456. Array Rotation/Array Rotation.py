def two(arr, N):
    new_arr = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            new_arr[j][N - 1 - i] = arr[i][j]

    for i in range(N):
        for j in range(N):
            arr[i][j] = new_arr[i][j]

def one(arr, i, N):
    tmp = arr[i][N - 1]
    for j in range(N - 1, 0, -1):
        arr[i][j] = arr[i][j - 1]
    arr[i][0] = tmp


N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))
Q = int(input())

for _ in range(Q):
    n = list(map(int, input().split()))
    if len(n) == 1:
        two(arr, N)
    else:
        one(arr, n[1] - 1, N)


for i in range(N):
    for j in range(N):
        print(arr[i][j], end=' ')
    print()



