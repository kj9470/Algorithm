n = int(input())

digits = []

while True:
    if n < 2:
        digits.append(n)
        break
    digits.append(n % 2)
    n //= 2

for d in digits[::-1]:
    print(d, end='')