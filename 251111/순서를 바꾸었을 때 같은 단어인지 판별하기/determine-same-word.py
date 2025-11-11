word1 = input()
word2 = input()

word1 = list(word1)
word2 = list(word2)

word1.sort()
word2.sort()

def compare(w1, w2):
    if len(w1) != len(w2):
        return False
    for i in range(len(w1)):
        if w1[i] != w2[i]:
            return False
    return True

if compare(word1, word2):
    print('Yes')
else:
    print('No')