import sys

input = sys.stdin.readline
N, M = map(int, input().split())

def result(list):
    if len(list) == M:
        for n in list:
            print(n, end=' ')
        print()
        return
    for i in range(1, N + 1):
        if i not in list:
            list.append(i)
            result(list)
            list.pop()

result([])