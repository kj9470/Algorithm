N, M = map(int, input().split())
lectures = list(map(int, input().split()))

start = 1
end = sum(lectures)
result = []

while start <= end:
    mid = (start + end) // 2

    if (mid < max(lectures)):
        start = mid + 1
        continue

    sum = 0
    count = 1
    for lecture in lectures:
        if (sum + lecture) <= mid:
            sum += lecture
        else:
            sum = lecture
            count += 1

    if count > M:
        start = mid + 1
    else:
        result.append(mid)
        end = mid - 1

print(min(result))