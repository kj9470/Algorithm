A, P = map(int, input().split())
seq = []
seq.append(A)
visited = dict()
visited[A] = 0
count = 1

while True:
    x = str(seq.pop(0))
    num_list = list(map(int, x.strip()))
    num = 0
    for n in num_list:
        num += n ** P
    if num in visited:
        print(visited[num])
        break
    else:
        visited[num] = count
        seq.append(num)
        count += 1