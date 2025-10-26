n1, n2 = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

def check(a, b):
    for i in range(len(a)):
        for j in range(len(b)):
            if a[i] != b[j]:
                return False
    return True


if check(a, b):
    print('Yes')
else:
    print('No')