from collections import Counter

def solution(want, number, discount):
    answer = 0
    total = Counter()
    
    for goods, num in zip(want, number):
        total[goods] = num

    for i in range(len(discount) - 9):
        discount_goods = Counter(discount[i:i + 10])
        if discount_goods == total:
            answer += 1

    return answer
