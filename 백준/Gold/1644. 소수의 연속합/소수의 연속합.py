import sys
import math

input = sys.stdin.readline
N = int(input())
prime_list = []
end = 0
count = 0
sum = 0

def is_prime(N):
    for i in range(2, int(math.sqrt(N)) + 1):
        if N % i == 0:
            return False
    return True

for i in range(2, N + 1):
    if is_prime(i) == True:
        prime_list.append(i)

for start in range(len(prime_list)):
    while end < len(prime_list) and sum < N:
        sum += prime_list[end]
        end += 1
    if sum == N:
        count += 1
    sum -= prime_list[start]

print(count)