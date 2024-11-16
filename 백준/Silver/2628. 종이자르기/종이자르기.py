width, height = map(int, input().split())

N = int(input())
cut = []
W = [0, width]
H = [0, height]

for i in range(N):
    x, y = map(int, input().split())
    if x == 0:
        H.append(y)
    else:
        W.append(y)

H.sort()
W.sort()
result = 0
for i in range(len(W) - 1):
    for j in range(len(H) - 1):
        width = W[i + 1] - W[i]
        height = H[j + 1] - H[j]
        result = max(result, width * height)
print(result)