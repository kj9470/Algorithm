n, m = map(int, input().split())

def LCM(n, m):
    count = 1
    while True:
        if count % n == 0 and count % m == 0:
            return count
        count += 1

print(LCM(n, m))
    