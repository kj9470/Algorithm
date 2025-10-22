n, m = map(int, input().split())

def square(n, m):
    for i in range(n):
        for j in range(m):
            print('1', end='')
        print()

square(n, m)