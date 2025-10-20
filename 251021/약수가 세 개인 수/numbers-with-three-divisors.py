start, end = map(int, input().split())
result = 0

for n in range(start, end + 1):
    divisor = 0
    for i in range(1, n + 1):
        if n % i == 0:
            divisor += 1
    if divisor == 3:
        result += 1

print(result)
