unlock_code, wire_color, seconds = input().split()
seconds = int(seconds)

class Bomb:
    def __init__(self, unlock, wire, second):
        self.unlock = unlock
        self.wire = wire
        self.second = second

bomb1 = Bomb(unlock_code, wire_color, seconds)

print('code :', bomb1.unlock)
print('color :', bomb1.wire)
print('second :', bomb1.second)