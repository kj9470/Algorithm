n = int(input())

class Local:
    def __init__(self, name, address, region):
        self.name = name
        self.address = address
        self.region = region

local = []
for _ in range(n):
    n_i, s_i, r_i = input().split()
    local.append(Local(n_i, s_i, r_i))

sorted_local = sorted(local, key=lambda s: s.name, reverse=True)

print('name', sorted_local[0].name)
print('addr', sorted_local[0].address)
print('city', sorted_local[0].region)