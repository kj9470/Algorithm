MAX_N = 5

codenames = []
scores = []
for _ in range(MAX_N):
    codename, score = input().split()
    codenames.append(codename)
    scores.append(int(score))

class CodeName:
    def __init__(self, name, score):
        self.name = name
        self.score = score

codename_info = []
for i in range(MAX_N):
    codename_info.append(CodeName(codenames[i], scores[i]))

min_score = 101
min_name = ''
for i in range(MAX_N):
    score = codename_info[i].score
    name = codename_info[i].name
    if score < min_score:
        min_score, min_name = score, name
    
print(min_name, min_score)