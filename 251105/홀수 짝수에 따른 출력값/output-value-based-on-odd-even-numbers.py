N = int(input())

def odd(N):
    if N == 1:
        return 1
    return odd(N - 2) + N

def even(N):
    if N == 2:
        return 2
    return aeven(N - 2) + N

def recursion(N):
    if N <= 2:
        return N
    return recursion(N - 2) + N

print(recursion(N))