N = int(input())
a = []
b = []

for i in range(N):
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    a = a[1:]
    b = b[1:]

    if a.count(4) > b.count(4):
        print('A')
    elif a.count(4) == b.count(4):
        if a.count(3) > b.count(3):
            print('A')
        elif a.count(3) == b.count(3):
            if a.count(2) > b.count(2):
                print('A')
            elif a.count(2) == b.count(2):
                if a.count(1) > b.count(1):
                    print('A')
                elif a.count(1) == b.count(1):
                    print('D')
                else:
                    print('B')
            else:
                print('B')
        else:
            print('B')
    else:
        print('B')