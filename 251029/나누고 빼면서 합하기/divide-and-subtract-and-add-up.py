n, m = map(int, input().split())
A = list(map(int, input().split()))

def calculation(n, m, A):
    result = 0
    while True:
        result += A[m - 1]
        if m == 1:
            return result
        if m % 2 == 1:
            m -= 1
        else:
            m //= 2

print(calculation(n, m, A))