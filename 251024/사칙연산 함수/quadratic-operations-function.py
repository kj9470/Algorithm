a, o, c = input().split()
a = int(a)
c = int(c)

def plus(a, c):
    return a + c

def minus(a, c):
    return a - c

def multiply(a, c):
    return a * c

def division(a, c):
    return a // c 

if o == '+':
    print(f'{a} + {c} = {plus(a, c)}')
elif o == '-':
    print(f'{a} - {c} = {minus(a, c)}')
elif o == '*':
    print(f'{a} * {c} = {multiply(a, c)}')
elif o == '/':
    print(f'{a} / {c} = {division(a, c)}')
else:
    print('False')