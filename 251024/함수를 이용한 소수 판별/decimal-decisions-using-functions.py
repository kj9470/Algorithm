a, b = map(int, input().split())
result = 0

def decimal(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

for i in range(a, b + 1):
    if decimal(i):
        result += i

print(result)