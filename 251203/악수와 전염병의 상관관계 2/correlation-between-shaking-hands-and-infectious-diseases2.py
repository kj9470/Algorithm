N, K, P, T = map(int, input().split())
handshakes = [tuple(map(int, input().split())) for _ in range(T)]

handshakes.sort(key=lambda x: x[0])

infections = [0] * (N + 1)
remain = [0] * (N + 1)

infections[P] = 1
remain[P] = K

for t, x, y in handshakes:
    if (infections[x] and remain[x] > 0) or (infections[y] and remain[y] > 0):
        if not infections[x]:
            infections[x] = 1
            remain[x] = K
        else:
            if remain[x] > 0:
                remain[x] -= 1
        if not infections[y]:
            infections[y] = 1
            remain[y] = K
        else:
            if remain[y] > 0:
                remain[y] -= 1

for i in range(1, N + 1):
    print(infections[i], end='')