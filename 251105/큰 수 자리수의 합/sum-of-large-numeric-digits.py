a, b, c = map(int, input().split())

def recursion(N):
    if N < 10:
        return N
    return recursion(N // 10) + N % 10

print(recursion(a * b * c))