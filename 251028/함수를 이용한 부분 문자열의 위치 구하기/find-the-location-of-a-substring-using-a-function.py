text = input()
pattern = input()

def find(test, pattern):
    index = 0
    for i in range(len(text)):
        if text[i:len(pattern) + i] == pattern:
            return i
    return -1

print(find(text, pattern))