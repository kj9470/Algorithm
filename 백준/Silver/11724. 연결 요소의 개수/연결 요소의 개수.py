import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for i in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


visited = [False] * (N + 1)
count = 0

def bfs(n):
    queue = deque([(n)])
    visited[n] = True

    while queue:
        n = queue.popleft()
        for i in graph[n]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

for i in range(1, N + 1):
    if not visited[i]:
        bfs(i)
        count += 1

print(count)