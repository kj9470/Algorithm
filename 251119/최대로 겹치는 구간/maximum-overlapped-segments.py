n = int(input())
segments = [tuple(map(int, input().split())) for _ in range(n)]

arr = [0 for _ in range(200)]
offset = 100
for s, e in segments:
    s += 100
    e += 100
    for i in range(s, e):
        arr[i] += 1

print(max(arr))