import bisect

T = int(input())

for _ in range(T):
    N = int(input())
    note1 = list(map(int, input().split()))
    M = int(input())
    note2 = list(map(int, input().split()))

    note1.sort()

    for i in note2:
        if note1[bisect.bisect(note1, i) - 1] == i:
            print(1)
        else:
            print(0)