N, M = map(int, input().split())
MAX_T = 1000000
arrA, arrB = [0] * (MAX_T + 1), [0] * (MAX_T + 1)
time = 1

for _ in range(N):
    v, t = map(int, input().split())
    for _ in range(t):
        arrA[time] = arrA[time - 1] + v
        time += 1

time = 1
for _ in range(M):
    v, t = map(int, input().split())
    for _ in range(t):
        arrB[time] = arrB[time - 1] + v
        time += 1

current = -1
result = 0
for i in range(len(arrA)):
    if arrA[i] > arrB[i] and current == 2:
        result += 1
        current = 1
    elif arrA[i] < arrB[i] and current == 1:
        result += 1
        current = 2
    elif arrA[i] > arrB[i]:
        current = 1
    elif arrA[i] < arrB[i]:
        current = 2

print(result)
