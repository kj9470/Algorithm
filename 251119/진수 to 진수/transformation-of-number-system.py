a, b = map(int, input().split())
n = input()

def upper(n, num):
    result = 0
    for i in range(len(num)):
        result = result * n + int(num[i])
    return result

def lower(n, num):
    digits = []
    
    while True:
        if num < n:
            digits.append(num)
            break
        digits.append(num % n)
        num //= n
    
    result = ''
    for d in digits[::-1]:
        result += str(d) 
    return result


num = upper(a, n)
print(lower(b, num))
