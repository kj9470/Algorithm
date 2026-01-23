T = int(input())
for test_case in range(1, T + 1):
	arr = list(map(int, input().split()))
	arr.sort()
	result = 0
	for i in range(1, 9):
		result += arr[i]
	if float(result / 8 % 1 >= 0.5):
		result //= 8
		result += 1
	else:
		result //= 8
	print(f'#{test_case} {result}')