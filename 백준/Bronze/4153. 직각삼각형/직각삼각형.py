while True:
    a, b, c = map(int, input().split())
    if a == b == c == 0:
        break
    max_n = max(a, b, c)
    tmp = 0
    for i in a, b, c:
        if i == max_n:
            continue
        else:
            tmp += (i * i)
    if max_n * max_n == tmp:
        print('right')
    else:
        print('wrong')