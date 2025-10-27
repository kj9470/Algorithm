A = input()

def count(A):
    c = A[0]
    for i in range(1, len(A)):
        if c != A[i]:
            return True
        
if count(A):
    print('Yes')
else:
    print('No')