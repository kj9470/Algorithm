N = int(input())

def recursion(a, b, N):
    if N == 1:
        return a
    return recursion(b, a * b % 100, N - 1)

print(recursion(2, 4, N))