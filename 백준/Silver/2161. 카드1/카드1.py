N = int(input())
arr = [ i + 1 for i in range(N) ]
arr.reverse()
result = []

while len(arr) > 1:
    result.append(arr.pop())
    arr.insert(0, arr.pop())

result.append(arr.pop())
print(*result)