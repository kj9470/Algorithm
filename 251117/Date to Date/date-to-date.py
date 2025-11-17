m1, d1, m2, d2 = map(int, input().split())

month_days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
result = 0
month_idx = m1

while True:
    if m1 == m2 and d1 == d2:
        break
    
    if d1 == month_days[month_idx]:
        m1 += 1
        d1 = 0
        result += 1
        month_idx += 1
    
    d1 += 1
    result += 1

print(result)