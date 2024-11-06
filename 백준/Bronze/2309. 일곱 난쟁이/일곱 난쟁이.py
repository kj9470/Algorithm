import sys

input = sys.stdin.readline
arr = []

def find(arr):
    for i in range(9):
        for j in range(i + 1, 9):
            if sum(arr) - 100 == arr[i] + arr[j]:
                arr.pop(i)
                arr.pop(j - 1)
                return arr

for _ in range(9):
    arr.append(int(input()))

find(arr)
arr.sort()

for i in range(7):
    print(arr[i])