N = int(input())
arr = [int(input()) for _ in range(N)]

count = 0
result = 0
for i in range(N):
    if i >= 1 and (arr[i] < 0 and arr[i - 1] < 0) or (arr[i] > 0 and arr[i - 1] > 0):
        count += 1
    else:
        count = 1
    result = max(result, count)

print(result)
