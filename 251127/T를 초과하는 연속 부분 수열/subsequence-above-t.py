n, t = map(int, input().split())
arr = list(map(int, input().split()))

count, result = 0, 0
for i in range(n):
    if i >= 1 and arr[i] > t and arr[i - 1] > t:
        count += 1
    else:
        count = 1
    result = max(count, result)

print(result)