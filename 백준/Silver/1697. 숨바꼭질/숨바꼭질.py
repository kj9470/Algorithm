from collections import deque

N, K = map(int, input().split())

mx = 100000
visited = [0] * (mx + 1)
queue = deque()

queue.append([N, 0])

def bfs():
    while True:
        V, count = queue.popleft()
        if V == K:
            return count
        if V >= 0 and V <= mx:
            if visited[V] == 0:
                queue.append([V + 1, count + 1])
                queue.append([V - 1, count + 1])
                queue.append([V * 2, count + 1])
                visited[V] = 1

print(bfs())
