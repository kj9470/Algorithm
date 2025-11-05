import sys
sys.setrecursionlimit(3000)

N = int(input())

def recursion(a, b, N):
    if N == 1:
        return b
    return recursion(b, a * b % 100, N - 1)

print(recursion(2, 4, N - 1))