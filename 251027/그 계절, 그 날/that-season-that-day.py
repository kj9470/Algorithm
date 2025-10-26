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
    if M in m31:
        if D <= 31:
            return True