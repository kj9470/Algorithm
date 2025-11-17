A, B, C, D = map(int, input().split())

result = 0
while True:
    if A == C and B == D:
        break
    
    if B == 60:
        B = 0
        A += 1

    result += 1
    B += 1

print(result)