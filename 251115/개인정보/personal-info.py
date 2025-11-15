class Student:
    def __init__(self, name, height, weight):
        self.name = name
        self.height = height
        self.weight = weight

n = 5
students = []

for _ in range(n):
    n, h, w = input().split()
    students.append(Student(n, int(h), float(w)))

students.sort(key=lambda x: (x.name))

print('name')
for s in students:
    print(f'{s.name} {s.height} {s.weight:.1f}')

print()
students.sort(key=lambda x: (-x.height))

print('height')
for s in students:
    print(f'{s.name} {s.height} {s.weight:.1f}')