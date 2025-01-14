K, N = map(int, input().split())

length = []
result = 0

for _ in range(K):
    k = int(input())
    length.append(k)

max_length = max(length)
min_length = 1

while min_length <= max_length:
    mid = (max_length + min_length) // 2
    if sum(lan // mid for lan in length) < N:
        max_length = mid - 1
    else:
        min_length = mid + 1
        result = mid

print(result)
