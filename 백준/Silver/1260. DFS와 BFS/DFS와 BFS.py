from collections import deque
import sys
input = sys.stdin.readline

N, M, V = map(int, input().split())

node = [[0] * (N + 1) for _ in range(N + 1)]
visited = [False] * (N + 1)

for _ in range(M):
    A, B = map(int, input().split())
    node[A][B] = 1
    node[B][A] = 1

def reset():
    for i in range(1, N + 1):
        visited[i] = False
    print()
def dfs(V):
    visited[V] = True
    print(V, end=' ')
    for i in range(1, N + 1):
        if not visited[i] and node[V][i] == 1:
            dfs(i)

def bfs(V):
    queue = deque([V])
    visited[V] = True
    while queue:
        x = queue.popleft()
        print(x, end=' ')
        for i in range(1, N + 1):
            if not visited[i] and node[x][i] == 1:
                queue.append(i)
                visited[i] = True

dfs(V)
reset()
bfs(V)