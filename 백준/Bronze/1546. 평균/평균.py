N = int(input())
score = list(map(int, input().split()))

max_score = max(score)
new_score = 0.0

for s in score:
    new_score += s / max_score * 100

print(new_score / N)