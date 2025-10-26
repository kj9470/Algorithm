n1, n2 = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

def same(n):
    for i in range(n2):
        if a[i + n] != b[i]: # n번째 인덱스부터 시작
            return False
    return True

def subsequence():
    for i in range(n1 - n2 + 1):
        if same(i):
            return True
    return False


if subsequence():
    print('Yes')
else:
    print('No')