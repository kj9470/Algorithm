A, B = map(str, input().split())

if len(A) > len(B):
    print(A, len(A))
else:
    print(B, len(B))