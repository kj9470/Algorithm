N, K = map(int, input().split())
result = 0
student = {}

for i in range(N):
    S, Y = map(int, input().split())
    if S == 0:
        if Y in student:
            student[Y] += 1
        else:
            student[Y] = 1
    elif S == 1:
        if Y + 6 in student:
            student[Y + 6] += 1
        else:
            student[Y + 6] = 1

arr = list(student.values())

for n in arr:
    if n <= K:
        result += 1
    elif n > K:
        tmp = n // K
        if n % K == 0:
            result += tmp
        else:
            result += tmp + 1

print(result)