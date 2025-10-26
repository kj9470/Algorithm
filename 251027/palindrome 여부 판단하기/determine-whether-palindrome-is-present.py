A = input()

def is_palindrome(A):
    reverse_a = ""
    for i in range(len(A) - 1, -1, -1):
        reverse_a += A[i]
    if A == reverse_a:
        return True
    else:
        return False

if is_palindrome(A):
    print('Yes')
else:
    print('No')