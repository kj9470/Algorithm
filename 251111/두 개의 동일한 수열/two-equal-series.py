n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort()

def sequence(A, B):
    for i in range(n):
        if A[i] != B[i]:
            return False
    return True

if sequence(A, B):
    print('Yes')
else:
    print('No')