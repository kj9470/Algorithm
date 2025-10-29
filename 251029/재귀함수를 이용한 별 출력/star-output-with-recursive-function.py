n = int(input())

def star(n, m):
    if m == n + 1:
        return
    print('*' * m)
    return star(n, m + 1)

star(n, 1)