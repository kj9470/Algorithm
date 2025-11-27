n = int(input())
arr = [int(input()) for _ in range(n)]

count = [0]
c = 1
i = 0
num = arr[i]
while i < n - 1:
    if num == arr[i + 1]:
        c += 1
        i += 1
    else:
        count.append(c)
        c = 1
        num = arr[i + 1]
        i += 1

count.append(c)
print(max(count))