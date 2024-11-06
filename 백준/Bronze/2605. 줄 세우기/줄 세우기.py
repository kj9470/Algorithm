n = int(input())
num = []
line = []

num = list(map(int, input().split()))

for i in range(len(num)):
  line.insert(num[i], i + 1)

line.reverse()
print(*line)