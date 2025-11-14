n = int(input())
arr = list(map(int, input().split()))
sorted_arr = []

for i in range(len(arr)):
    sorted_arr.append(arr[i])
    sorted_arr.sort()
    if (i + 1) % 2 == 1:
        print(sorted_arr[len(sorted_arr) // 2], end=' ')