n, m = map(int, input().split())
arr = list(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(m)]

def sum_of_section(arr, a1, a2):
    result = 0
    for i in range(a1 - 1, a2):
        result += arr[i]
    return result

for a1, a2 in queries:
    print(sum_of_section(arr, a1, a2))
        