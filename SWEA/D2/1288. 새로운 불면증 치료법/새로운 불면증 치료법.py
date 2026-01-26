T = int(input())
for num in range(1, T + 1):
    N = int(input())
    s = set()
    i = 1
    tmp = str(N)
    while True:
        for j in range(len(tmp)):
            s.add(tmp[j])
        if len(s) >= 10:
            break
        i += 1
        tmp = str(i * N)
    print(f'#{num}', tmp)
