n = int(input())

def recursion(N, count):
    if N == 1:
        return count
    if N % 2 == 0:
        recursion(N // 2, count + 1)
    else:
        recursion(N * 3 + 1, count + 1)