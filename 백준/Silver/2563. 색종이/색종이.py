n = int(input())
arr = [[0] * 100 for k in range(100)]

for _ in range(n):
  a, b = map(int, input().split())
  for i in range(a, a + 10):
    for j in range(b, b + 10):
      arr[i][j] = 1

result = 0
for i in range(100):
  result += arr[i].count(1)

print(result)