import sys
input = sys.stdin.readline

N, M = map(int, input().split())
dict = {}

for _ in range(N):
    key, value = map(str, input().split())
    dict[key] = value

for _ in range(M):
    key = input().strip()
    print(dict[key])