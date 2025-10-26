Y, M, D = map(int, input().split())

spring = [3, 4, 5]
summer = [6, 7, 8]
fall = [9, 10, 11]
winter = [12, 1, 2]

m31 = [1, 3, 5, 7, 8, 10, 12]
m30 = [4, 6, 9, 11]
m28 = [2]
m29 = [2]

def is_leap_year(Y):
    if Y % 4 == 0:
        if Y % 100 == 0:
            if Y % 400 == 0:
                return True
            else:
                return False
        else:
            return True

def is_day(Y, M, D):
    if is_leap_year(Y):
        if M in m29:
            if D <= 29:
                return True
    if M in m31:
        if D <= 31:
            return True
    if M in m30:
        if D <= 30:
            return True
    if M in m28:
        if D <= 28:
            return True
    else:
        return False

def season(M):
    if M in spring:
        return 'Spring'
    elif M in summer:
        return 'Summer'
    elif M in fall:
        return 'Fall'
    else:
        return 'Winter'

if is_day(Y, M, D):
    print(season(M))
else:
    print(-1)