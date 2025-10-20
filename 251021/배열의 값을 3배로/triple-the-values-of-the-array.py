arr = []
for i in range(3):
    arr.append(list(map(int, input().split())))

for i in range(3):
    for j in range(3):
        arr[i][j] *= 3
        print(arr[i][j], end=' ')
    print()