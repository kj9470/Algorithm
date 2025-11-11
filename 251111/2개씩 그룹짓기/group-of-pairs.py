n = int(input())
nums = list(map(int, input().split()))

nums.sort()
max_num = 0

for i in range(n):
    if nums[i] + nums[2 * n - 1 - i] > max_num:
        max_num = nums[i] + nums[2 * n - 1 - i]

print(max_num)