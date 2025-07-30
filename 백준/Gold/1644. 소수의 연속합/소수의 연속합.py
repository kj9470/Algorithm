import sys

input = sys.stdin.readline
N = int(input())
end = 0
count = 0
sum = 0

def is_prime(N):
    prime_list = [i for i in range(N + 1)]
    end = int(N**(1/2))
    for i in range(2, end + 1):
        if prime_list[i] == 0:
            continue
        for j in range(i * i, N + 1, i):
            prime_list[j] = 0
    return [i for i in prime_list[2:] if prime_list[i]]

prime_list = is_prime(N)

for start in range(len(prime_list)):
    while end < len(prime_list) and sum < N:
        sum += prime_list[end]
        end += 1
    if sum == N:
        count += 1
    sum -= prime_list[start]

print(count)