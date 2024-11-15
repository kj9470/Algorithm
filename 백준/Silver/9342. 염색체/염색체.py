import sys

input = sys.stdin.readline
T = int(input())

def check(str):
    i = 0
    if str[0] in ['A', 'B', 'C', 'D', 'E', 'F']:
        if not str[0] == 'A':
            i += 1
        while i < len(str):
            if str[i] == 'A':
                while str[i] == 'A':
                    i += 1
            else:
                return False
            if str[i] == 'F':
                while str[i] == 'F':
                    i += 1
            else:
                return False
            if str[i] == 'C':
                while i < len(str) and str[i] == 'C':
                    i += 1
                if str[-1] in ['A', 'B', 'C', 'D', 'E', 'F']:
                    return True
                else:
                    return False
            else:
                return False
    else:
        return 0

for _ in range(T):
    str = input().strip()
    if check(str):
        print("Infected!")
    else:
        print("Good")
