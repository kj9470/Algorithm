N, Z, M = map(int, input().split())
mm = set(map(int, input().split()))

for r in range(1, N + 1):
    i = 1
    visited = set()

    while True:
        if i == Z:
            print(r)
            exit()

        if i in mm:
            break

        if i in visited:
            break
        visited.add(i)

        i += r
        i = (i - 1) % N + 1