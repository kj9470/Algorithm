import sys

input = sys.stdin.readline
T = int(input())

def pal(str, flag):
    arr = []
    for i in range(len(str) // 2):
        if str[i] != str[len(str) - 1 - i]:
            arr.append(str[:i] + str[i+1:])
            tmp = len(str) - i - 1
            arr.append(str[:tmp] + str[tmp+1:])
            if flag:
                return 2
            else:
                return arr
    if flag:
        return 1
    else:
        return 0

for _ in range(T):
    res = -1
    S = input().strip()
    ans = pal(S, False)
    if isinstance(ans, int):
        print(pal(S, False))
    else:
        if isinstance(ans, list):
            a = pal(ans[0], True)
            b = pal(ans[1], True)
            if isinstance(a, int) and isinstance(b, int):
                if a < b:
                    print(a)
                else:
                    print(b)