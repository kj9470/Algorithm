n = int(input())

def recursion(n):
    if n == 0:
        return
    print('HelloWorld');
    return recursion(n - 1)

recursion(n)