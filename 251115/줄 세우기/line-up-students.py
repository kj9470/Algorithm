n = int(input())
students = []

class Student:
    def __init__(self, height, weight, number):
        self.height = height
        self.weight = weight
        self.number = number

number = 1
for _ in range(n):
    h, w = map(int, input().split())
    students.append(Student(h, w, number))
    number += 1

students.sort(key=lambda x: (-x.height, -x.weight, x.number))

for student in students:
    print(student.height, student.weight, student.number)

