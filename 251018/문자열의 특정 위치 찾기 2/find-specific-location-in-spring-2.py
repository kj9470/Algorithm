arr = ["apple", "banana", "grape", "blueberry", "orange"]

w = input()
result = 0
result_arr = []

for fruit in arr:
    if fruit[2] == w or fruit[3] == w:
        result_arr.append(fruit)
        result += 1

for w in result_arr:
    print(w)
print(result)