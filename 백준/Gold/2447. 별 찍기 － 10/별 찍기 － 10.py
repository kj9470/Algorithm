import sys

input = sys.stdin.readline
N = int(input())

def star(n):
    starList = ["***", "* *", "***"]
    if n == 3:
        return starList
    arr = star(n // 3)
    starList = []

    for i in arr:
        starList.append(i * 3)
    for i in arr:
        starList.append(i + ' ' * (n // 3) + i)
    for i in arr:
        starList.append(i * 3)

    return starList

res = star(N)
list(map(print, res))
