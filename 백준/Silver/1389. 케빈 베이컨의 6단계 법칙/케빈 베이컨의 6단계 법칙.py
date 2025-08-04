import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
node = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B = map(int, input().split())
    node[A].append(B)
    node[B].append(A)

def bfs(x):
    queue = deque([(x, 0)])
    visited = [False] * (N + 1)
    visited[x] = True
    count = 0

    while queue:
        n, q_count = queue.popleft()
        count += q_count
        for nx in node[n]:
            if not visited[nx]:
                visited[nx] = True
                queue.append((nx, q_count + 1))
    return count

min_n = float('inf')
result = 0

for i in range(1, N + 1):
    n = bfs(i)
    if n < min_n:
        min_n = n
        result = i

print(result)