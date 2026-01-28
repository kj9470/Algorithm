T = int(input())

for tc in range(1, T + 1):
    bit = input()
    bits = []
    for b in bit:
        bits.append(int(b))

    answer = [0 for _ in range(len(bits))]
    count = 0
    i = 0

    while True:
        if bits == answer:
            break
        if bits[i] != answer[i]:
            for j in range(i, len(bits)):
                if bits[j] == 0:
                    bits[j] = 1
                else:
                    bits[j] = 0
            count += 1
        i += 1
    print(f'#{tc} {count}')