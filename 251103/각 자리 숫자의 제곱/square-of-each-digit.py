N = int(input())

def recursion(N):
    if N < 10:
        return N * N
    return recursion(N // 10) + recursion(N % 10)

print(recursion(N))