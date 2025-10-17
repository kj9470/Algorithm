A, B = map(str, input().split())

if len(A) > len(B):
    print(A, len(A))
elif len(A) == len(B):
    print('same')
else:
    print(B, len(B))