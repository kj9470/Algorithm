class Student:
    def __init__(self, name, height, weight):
        self.name = name
        self.height = height
        self.weight = weight

n = int(input())
students = []

for _ in range(n):
    n, h, w = input().split()
    students.append(Student(n, int(h), int(w)))

students.sort(key=lambda x: (x.height, -x.weight))

for s in students:
    print(f'{s.name} {s.height} {s.weight}')