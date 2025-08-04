import sys
from collections import deque

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    seq = list(map(int, input().split()))
    seq.insert(0, 0)

    visited = [False] * (N + 1)
    count = 0

    def bfs(x, visited):
        queue = deque([x])
        visited[x] = True

        while queue:
            i = queue.popleft()
            nx = seq[i]
            if not visited[nx]:
                queue.append(nx)
                visited[nx] = True

    for i in range(1, N + 1):
        if not visited[i]:
            bfs(i, visited)
            count += 1

    print(count)