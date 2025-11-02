N = int(input())

def recursion(N):
    if N == 1:
        return 1
    return recursion(N - 1) + N

print(recursion(N))