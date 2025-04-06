computer = int(input())
network = int(input())

graph = [[] for _ in range(computer + 1)]
visited = [False] * (computer + 1)

for _ in range(network):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

dfs(graph, 1, visited)

result = visited.count(True)
if result:
    print(result - 1)
else:
    print(0)