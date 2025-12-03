N, K, P, T = map(int, input().split())
handshakes = [tuple(map(int, input().split())) for _ in range(T)]

infections = [0] * (N + 1)
handshakes.sort(key=lambda x: x[0])
flag = False

for t, x, y in handshakes:
    if x == P:
        flag = True
        infections[x] = 1
        infections[y] = 1
        K -= 1
    if flag and K > 0:
        infections[y] = 1
        K -= 1

for i in range(1, N + 1):
    print(infections[i], end='')