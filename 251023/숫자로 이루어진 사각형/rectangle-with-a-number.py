n = int(input())

def make_square(n):
    num = 1
    for i in range(n):
        for j in range(n):
            if num < 10:
                print(num, end=' ')
            else:
                num = 1
                print(num, end=' ')
            num += 1
        print()

make_square(n)