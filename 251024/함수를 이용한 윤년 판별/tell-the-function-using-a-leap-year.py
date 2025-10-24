y = int(input())

def year(y):
    if y % 4 == 0:
        if y % 100 == 0 and y % 400 != 0:
            print('false')
            return
        print('true')
    else:
        print('false')

year(y)