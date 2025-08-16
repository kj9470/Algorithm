import sys
input = sys.stdin.readline

N, M = map(int, input().split())
pokedex = dict()

for i in range(1, N + 1):
    pokedex[str(i)] = input().strip()

reverse_pokemon = {v:k for k, v in pokedex.items()}

for _ in range(M):
    quiz = input().strip()
    if quiz.isalpha():
        print(reverse_pokemon[quiz])
    else:
        print(pokedex[quiz])
