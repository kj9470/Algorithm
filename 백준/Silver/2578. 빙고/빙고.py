arr = []
board = {}
num = []
check = 0

visited = [[0] * 5 for _ in range(5)]
for i in range(5):
    arr.append(list(map(int, input().split())))
    for j in range(5):
        board[arr[i][j]] = [j, i]
for _ in range(5):
    num.append(list(map(int, input().split())))

def bingo(x, y):
    result = 0
    for i in range(5):
        if visited[i][0] == 1:
            if len(set(visited[i])) == 1:
                result += 1

    for i in range(5):
        temp = 0
        for j in range(5):
            if visited[j][i] == 1:
                temp += 1
            if temp == 5:
                result += 1
    temp = 0
    for i in range(5):
        if visited[i][i] == 1:
            temp += 1
        if temp == 5:
            result += 1
    temp = 0
    for i in range(5):
        if visited[i][4-i] == 1:
            temp += 1
        if temp == 5:
            result += 1
    if result >= 3:
        return True

for i in range(5):
    for j in range(5):
        if check >= 12:
            if bingo(i, j):
                print(check)
                exit()
        check += 1
        x = board[num[i][j]][0]
        y = board[num[i][j]][1]
        visited[x][y] = 1