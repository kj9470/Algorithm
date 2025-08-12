import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M, R = map(int, input().split())
node = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
order = [0] * (N + 1)
count = 1

for _ in range(M):
    A, B = map(int, input().split())
    node[A].append(B)
    node[B].append(A)

for arr in node:
    arr.sort(reverse=True)

def dfs(V):
    global count
    visited[V] = True
    order[V] = count
    for x in node[V]:
        if not visited[x]:
            count += 1
            dfs(x)

dfs(R)

for i in range(1, N + 1):
    print(order[i])