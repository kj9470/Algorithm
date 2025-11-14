user2_id, user2_level = input().split()
user2_level = int(user2_level)

class User:
    def __init__(self, id, level):
        self.id = id
        self.level = level

user1 = User('codetree', 10)
user2 = User(user2_id, user2_level)

print(f'user {user1.id} lv {user1.level}')
print(f'user {user2.id} lv {user2.level}')
