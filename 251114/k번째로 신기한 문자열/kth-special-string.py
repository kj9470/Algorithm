n, k, t = input().split()
n, k = int(n), int(k)
str = [input() for _ in range(n)]

sorted_str = []

for word in str:
    if word[:len(t)] == t:
        sorted_str.append(word)

sorted_str.sort()

print(sorted_str[k - 1])