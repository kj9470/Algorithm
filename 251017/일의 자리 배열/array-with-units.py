a, b = map(int, input().split())

arr = [a, b]

for i in range(2, 10):
    arr.append(arr[i - 1] + arr[i - 2])

for i in range(len(arr)):
    print(arr[i] % 10, end=' ')