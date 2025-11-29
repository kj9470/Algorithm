N, M, K = map(int, input().split())
student = [int(input()) for _ in range(M)]

penalty = [0] * (N + 1)

for s in student:
    penalty[s] += 1
    if penalty[s] >= K:
        print(s)
        exit()

print(-1)