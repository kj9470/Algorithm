M, D = map(int, input().split())

m31 = [1, 3, 5, 7, 8, 10, 12]
m30 = [4, 6, 9, 11]
m28 = [2]

def isDay(m, d):
    if d < 0 or m < 0:
        return False
    if m in m31:
        if d <= 31:
            return True
    if m in m30:
        if d <= 30:
            return True
    if m in m28:
        if d <= 28:
            return True

if isDay(M, D):
    print('Yes')
else:
    print('No') 