class Student:
    def __init__(self, name, k, e, m):
        self.name = name
        self.k = k
        self.e = e
        self.m = m

n = int(input())
students = []

for _ in range(n):
    name, k, e, m = map(str, input().split())
    students.append(Student(name, int(k), int(e), int(m)))

students.sort(key=lambda x: (-x.k, -x.e, -x.m))

for i in range(n):
    print(students[i].name, students[i].k, students[i].e, students[i].m)