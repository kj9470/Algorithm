T = int(input())

for i in range(1, T + 1):
    P, A, B = map(int, input().split())
    aLeft, aRight = 1, P
    bLeft, bRight = 1, P

    while aLeft < aRight or bLeft < bRight:
        if (aLeft + aRight) // 2 == A and (bLeft + bRight) // 2 == B:
            print(f'#{i} 0')
            break
        elif (aLeft + aRight) // 2 == A:
            print(f'#{i} A')
            break
        elif (bLeft + bRight) // 2 == B:
            print(f'#{i} B')
            break

        if (aLeft + aRight) // 2 > A:
            aRight = (aLeft + aRight) // 2
        elif (aLeft + aRight) // 2 < A:
            aLeft = (aLeft + aRight) // 2
        if (bLeft + bRight) // 2 > B:
            bRight = (bLeft + bRight) // 2
        elif (bLeft + bRight) // 2 < B:
            bLeft = (bLeft + bRight) // 2