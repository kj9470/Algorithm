N = int(input())
result = 0

for i in range(N):
    if i % 2 == 0 or i % 3 == 0 or i % 5 == 0:
        continue
    else:
        result += 1

print(result)