n, m = map(int, input().split())

t_a = []
d_a = []
for _ in range(n):
    time, direction = input().split()
    t_a.append(int(time))
    d_a.append(direction)

t_b = []
d_b = []
for _ in range(m):
    time, direction = input().split()
    t_b.append(int(time))
    d_b.append(direction)

total_a = sum(t_a)
total_b = sum(t_b)
T = max(total_a, total_b)

pos_a = [0] * (T + 1)
pos_b = [0] * (T + 1)

time = 1
i = 0
remain = t_a[0]
dir = d_a[0]
while time <= T:
    if i < n and remain > 0:
        pos_a[time] = pos_a[time - 1] + (1 if dir == 'R' else -1)
        remain -= 1
        if remain == 0:
            i += 1
            if i < n:
                remain = t_a[i]
                dir = d_a[i]
    else:
        pos_a[time] = pos_a[time - 1]
    time += 1


time = 1
i = 0
remain = t_b[0]
dir = d_b[0]
while time <= T:
    if i < m and remain > 0:
        pos_b[time] = pos_b[time - 1] + (1 if dir == 'R' else -1)
        remain -= 1
        if remain == 0:
            i += 1
            if i < m:
                remain = t_b[i]
                dir = d_b[i]
    else:
        pos_b[time] = pos_b[time - 1]
    time += 1

count = 0
for t in range(1, T + 1):
    if pos_a[t] == pos_b[t] and pos_a[t - 1] != pos_b[t - 1]:
        count += 1
        
print(count)