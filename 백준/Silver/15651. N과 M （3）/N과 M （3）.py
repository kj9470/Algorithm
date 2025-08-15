import sys
input = sys.stdin.readline

N, M = map(int, input().split())
stack = []
result = []

def dfs():
    if len(stack) == M:
        result.append(list(stack))
        return
    for i in range(1, N + 1):
        stack.append(i)
        dfs()
        stack.pop()

dfs()

unique_result = []
for row in result:
    print(*row)