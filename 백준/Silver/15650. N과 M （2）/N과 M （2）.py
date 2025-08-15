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
        if i not in stack:
            stack.append(i)
            dfs()
            stack.pop()

dfs()

unique_result = []
for row in result:
    row.sort()
    if row not in unique_result:
        unique_result.append(row)
        print(*row)