num = []
for _ in range(10):
    num.append(int(input()))

three, five = 0, 0

for n in num:
    if n % 3 == 0:
        three += 1
    if n % 5 == 0:
        five += 1

print(three, five)