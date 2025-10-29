n = int(input())

def recursion1(n, m):
    if m == n + 1:
        return
    print(m, end=' ')
    recursion1(n, m + 1)

def recursion2(n):
    if n == 0:
        return
    print(n, end=' ')
    recursion2(n - 1)

recursion1(n, 1)
print()
recursion2(n)