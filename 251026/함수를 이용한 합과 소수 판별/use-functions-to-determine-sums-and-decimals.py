a, b = map(int, input().split())

def decimal(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def check(n):
    if sum(map(int, str(n))) % 2 == 0:
        return True
    else:
        return False

count = 0
for i in range(a, b + 1):
    if decimal(i) and check(i):
        count += 1

print(count)