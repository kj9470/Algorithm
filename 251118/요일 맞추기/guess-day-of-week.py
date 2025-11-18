m1, d1, m2, d2 = map(int, input().split())

month = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
week = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']

def days(m, d):
    day = 0
    for i in range(1, m):
        day += month[m]
    day += d
    return day

result = days(m2, d2) - days(m1, d1)
print(week[(result + 7) % 7])