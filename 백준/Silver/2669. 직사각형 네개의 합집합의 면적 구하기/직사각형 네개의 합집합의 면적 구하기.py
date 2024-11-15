arr = [[ 0 for _ in range(100) ] for _ in range(100) ]
count = 0

for _ in range(4):
    x, y, width, height = map(int, input().split())
    for i in range(x, width):
        for j in range(y, height):
            arr[i][j] = 1

count = 0
for i in range(len(arr)):
    count += arr[i].count(1)

print(count)