T = int(input())

for i in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))

    avg = sum(arr) / len(arr)
    result = 0
    for j in range(N):
        if arr[j] <= avg:
            result += 1
    print(f'#{i} {result}')