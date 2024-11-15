def winner(n, a, b):
    if a.count(n) > b.count(n):
        print('A')
        return
    elif a.count(n) == b.count(n):
        if n == 1:
            print('D')
            return
        else:
            winner(n - 1, a, b)
    else:
        print('B')
        return

N = int(input())
a = []
b = []

for i in range(N):
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    a = a[1:]
    b = b[1:]

    winner(4, a, b)
