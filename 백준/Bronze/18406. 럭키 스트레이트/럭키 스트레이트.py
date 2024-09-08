N = int(input())
center = len(str(N)) // 2
a, b = 0, 0
for n in str(N):
    if center > 0:
        a += int(n)
        center -= 1
    else:
        b += int(n)

if a == b:
    print("LUCKY")
else:
    print("READY")