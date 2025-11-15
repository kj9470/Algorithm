class Point:
    def __init__(self, num, x, y):
        self.num = num
        self.x = x
        self.y = y

n = int(input())
points = []

num = 1
for _ in range(n):
    x, y = map(int, input().split())
    points.append(Point(num, x, y))
    num += 1

points.sort(key=lambda x: (abs(x.x) + abs(x.y)))

for p in points:
    print(p.num)