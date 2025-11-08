N = int(input())

def recursion(N):
    if N <= 2:
        return N
    return recursion(N // 3) + recursion(N - 1)

print(recursion(N))