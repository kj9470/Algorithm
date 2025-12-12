n, t = map(int, input().split())
r, c, d = input().split()
r, c = int(r), int(c)

# 방향 벡터
drdc = {
    'U': (-1, 0),
    'D': (1, 0),
    'L': (0, -1),
    'R': (0, 1),
}

opp = {'U': 'D', 'D': 'U', 'L': 'R', 'R': 'L'}

seen = {}
elapsed = 0

while elapsed < t:
    state = (r, c, d)
    if state in seen:
        cycle_len = elapsed - seen[state]
        remain = t - elapsed
        if cycle_len > 0:
            skip = (remain // cycle_len) * cycle_len
            elapsed += skip
            if elapsed >= t:
                break
    else:
        seen[state] = elapsed

    dr, dc = drdc[d]
    nr, nc = r + dr, c + dc

    if not (1 <= nr <= n and 1 <= nc <= n):
        d = opp[d]
    else:
        r, c = nr, nc

    elapsed += 1

print(r, c)
