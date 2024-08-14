def solution(keymap, targets):
    answer = []
    dic = {}
    key = "".join(targets)
    key = list(set(key))
    dic = dict.fromkeys(key, 999)

    for map in keymap:
        for i in range(len(map)):
            m = map[i]
            if (m in dic and dic[m] > i + 1):
                dic[m] = i + 1

    for tar in targets:
        tmp = 0
        for t in tar:
            v = dic[t]
            if v == 999:
                tmp = -1
                break
            tmp += int(dic[t])
        answer.append(tmp)
    return answer