import sys
from collections import deque
input = sys.stdin.readline

S = int(input())
MAX = 3001
queue = deque([(1, 0, 0)]) # 화면, 클립보드, count
visited = [False] * MAX

def bfs(S):
    while queue:
        current, clipboard, count = queue.popleft()
        if current == S:
            print(count)
            return
        if not visited[current]: # 화면에 이모지 개수 출력했을 시 표시
            visited[current] = True
            queue.append((current, current, count + 1))
        if current + clipboard <= MAX: # 복붙
            queue.append((current + clipboard, clipboard, count + 1))
        if current - 1 >= 0: # 이모지 삭제
            queue.append((current - 1, clipboard, count + 1))

bfs(S)