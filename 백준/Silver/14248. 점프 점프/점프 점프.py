n = int(input())
arr = list(map(int, input().split()))
s = int(input())
count = 1
v = [0] * n

def dfs(x):
    global count
    for nx in (x + arr[x], x - arr[x]):
        if 0 <= nx < n and v[nx] == 0:
            count += 1
            v[nx] = 1
            dfs(nx)
            
dfs(s - 1)
print(count)