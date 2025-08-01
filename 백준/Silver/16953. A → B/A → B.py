from collections import deque

A, B = map(int, input().split())
queue = deque([(A, 1)])

while queue:
    x, count = queue.popleft()
    for nx in (x * 2, int(str(x) + "1")):
        if nx == B:
            print(count + 1)
            exit()
        elif nx < B:
            queue.append((nx, count + 1))

print(-1)