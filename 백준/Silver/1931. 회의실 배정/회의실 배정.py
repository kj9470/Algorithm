import sys

input = sys.stdin.readline
N = int(input())
meetings = []

for _ in range(N):
    meetings.append(list(map(int, input().split())))

meetings.sort(key=lambda x: (x[1], x[0]))

endMeeting = 0
result = 0

for start, end in meetings:
    if endMeeting <= start:
        result += 1
        endMeeting = end

print(result)