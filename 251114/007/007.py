secret_code, meeting_point, time = input().split()
time = int(time)

class Secret:
    def __init__(self, code, meeting, time):
        self.code = code
        self.meeting = meeting
        self.time = time

secret1 = Secret(secret_code, meeting_point, time)

print('secret code :', secret1.code)
print('meeting point :', secret1.meeting)
print('time :', secret1.time)