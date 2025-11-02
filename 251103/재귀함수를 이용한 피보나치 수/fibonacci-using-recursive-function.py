N = int(input())

def recusrion(N):
    if N <= 1:
        return N
    return recusrion(N - 1) + recusrion(N - 2)

print(recusrion(N))