n = int(input())
sequence = list(map(int, input().split()))

class Number:
    def __init__(self, n, idx, after):
        self.n = n
        self.idx = idx
        self.after = after

sequences = []
for i in range(n):
    sequences.append(Number(sequence[i], i + 1, 0))

sequences.sort(key=lambda x: x.n)

for i in range(n):
    sequences[i].after = i + 1

sequences.sort(key=lambda x: x.idx)

for seq in sequences:
    print(seq.after, end=' ')