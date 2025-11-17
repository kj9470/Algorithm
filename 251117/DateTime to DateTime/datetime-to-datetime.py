a, b, c = map(int, input().split())
d, h, m = 11, 11, 11

if a < d or (a == d and b < d) or (a == d and b == d and c < m):
    print(-1)
    exit()

minute = 0
while True:
    if d == a and h == b and m == c:
        break
    
    if m == 60:
        h += 1
        m = 0
    if h == 24:
        d += 1
        h = 0
    
    m += 1
    minute += 1

print(minute)