S = input()

def generate_permutations(chars, current, used, last_char):
    if len(current) == len(chars):
        return 1

    count = 0
    for i in range(len(chars)):
        if used[i] or (i > 0 and chars[i] == chars[i - 1] and not used[i - 1]):
            continue
        if len(current) > 0 and chars[i] == last_char:
            continue

        used[i] = True
        count += generate_permutations(chars, current + chars[i], used, chars[i])
        used[i] = False

    return count

def count_lucky_permutaions(s):
    chars = sorted(s)
    used = [False] * len(s)
    return generate_permutations(chars, "", used, "\0")

result = count_lucky_permutaions(S)
print(result)