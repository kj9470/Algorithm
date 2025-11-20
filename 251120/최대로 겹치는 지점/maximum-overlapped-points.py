n = int(input())
segments = [tuple(map(int, input().split())) for _ in range(n)]

arr = [ 0 for _ in range(101) ]
for s, e in segments:
    for i in range(s, e + 1):
        arr[i] += 1


print(max(arr))