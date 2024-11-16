import sys

input = sys.stdin.readline
N = int(input())
hanoiList = []

def hanoi(list, n, start, tmp, end):
    if n == 1:
        list.append(start + " " + end)
    else:
        hanoi(list, n - 1, start, end, tmp)
        hanoi(list, 1, start, tmp, end)
        hanoi(list, n - 1, tmp, start, end)

hanoi(hanoiList, N, '1', '2', '3')
print(len(hanoiList))
list(map(print, hanoiList))