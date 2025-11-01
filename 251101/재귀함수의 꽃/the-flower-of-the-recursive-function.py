N = int(input())

def recursion(N):
    if N == 0:
        return
    print(N, end=' ')
    recursion(N - 1)
    print(N, end=' ')

recursion(5)