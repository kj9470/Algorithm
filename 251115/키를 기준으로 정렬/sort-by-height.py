n = int(input())
info = []

class Info:
    def __init__(self, name, height, weight):
        self.name = name
        self.height = height
        self.weight = weight

for _ in range(n):
    n_i, h_i, w_i = input().split()
    info.append(Info(n_i, h_i, w_i))

info.sort(key=lambda x: x.height)

for i in range(len(info)):
    print(info[i].name, info[i].height, info[i].weight)