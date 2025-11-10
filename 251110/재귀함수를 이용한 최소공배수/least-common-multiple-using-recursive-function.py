n = int(input())
arr = list(map(int, input().split()))

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

def recursion(arr):
    if len(arr) == 1:
        return arr[0]
    return lcm(arr[0], recursion(arr[1:]))

print(recursion(arr))