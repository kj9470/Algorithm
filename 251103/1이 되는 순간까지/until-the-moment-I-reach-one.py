N = int(input())

def recursion(N, count):
    if N == 1:
        return count
    if N % 2 == 0:
        return recursion(N // 2, count + 1)
    else:
        return recursion(N // 3, count + 1)

print(recursion(N, 0))