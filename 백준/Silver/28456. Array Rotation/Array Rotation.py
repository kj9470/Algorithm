import sys
input=sys.stdin.readline

N = int(input())

lst = [[] for i in range(N)]

for i in range(N):
    line = list(map(int, input().split()))
    for j in range(N):
        lst[i].append(line[j])

Q = int(input())

for _ in range(Q):
    command = list(map(int, input().split()))
    if command[0] == 1:
        lst[command[1] - 1] = lst[command[1] - 1][-1:] + lst[command[1] - 1][:-1]
    elif command[0] == 2:
        lstA = [[] for i in range(N)]
        for i in range(N - 1, -1, -1):
            for j in range(N):
                lstA[j].append(lst[i][j])
        lst = lstA

for i in range(N):
    for j in range(N):
        print(lst[i][j], end=" ")
    print()
