N, M = map(int, input().split())
MAX_T = 1000000
arrA, arrB = [0] * (MAX_T + 1), [0] * (MAX_T + 1)
time = 1

for _ in range(N):
    v, t = map(int, input().split())
    for _ in range(t):
        arrA[time] = arrA[time - 1] + v
        time += 1
lenA = time - 1

time = 1
for _ in range(M):
    v, t = map(int, input().split())
    for _ in range(t):
        arrB[time] = arrB[time - 1] + v
        time += 1
lenB = time - 1

T = max(lenA, lenB)
current = 0
result = 0
lead = 0

for i in range(1, T + 1):
    if arrA[i] > arrB[i]:
        lead = 1
    elif arrA[i] < arrB[i]:
        lead = 2
    else:
        lead = 0

    if lead != current:
        result += 1
        current = lead

print(result)
