m1, d1, m2, d2 = map(int, input().split())
A = input()

month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
week = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']

def days(m, d):
    day = 0
    for i in range(1, m):
        day += month[i]
    day += d
    return day

result = days(m2, d2) - (days(m1, d1) + week.index(A))
print(result // 7 + 1)