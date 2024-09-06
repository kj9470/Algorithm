N = int(input())
tmp = N
answer = 0

while True:
    answer += 1
    a = tmp // 10
    b = tmp % 10
    plusN = (a + b) % 10
    tmp = b * 10 + plusN
    if tmp == N:
        break

print(answer)