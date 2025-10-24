n = int(input())

def count(n):
    result = 0
    for i in range(1, n + 1):
        result += i
    return result // 10

print(count(n))