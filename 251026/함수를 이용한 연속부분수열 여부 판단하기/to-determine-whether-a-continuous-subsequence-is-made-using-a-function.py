n1, n2 = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

def check(a, b):
    for i in range(len(a)- 1):
        for j in range(len(b) - 1):
            if a[i] == b[j]:
                if a[i + 1] == b[j + 1]:
                    return True
    return False

if check(a, b):
    print('Yes')
else:
    print('No')