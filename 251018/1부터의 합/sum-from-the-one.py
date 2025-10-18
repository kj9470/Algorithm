N = int(input())
answer = 0

for i in range(1, 100):
    answer += i
    if answer >= N:
        print(i)
        break