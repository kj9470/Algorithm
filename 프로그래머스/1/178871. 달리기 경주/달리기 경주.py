def solution(players, callings):
    answer = []
    dic = { player : rank for rank, player in enumerate(players) }
    
    for call in callings:
        pre, index = dic[call] - 1 , dic[call]  
        players[pre], players[index] = players[index], players[pre]  
        dic[players[pre]] -= 1  
        dic[players[index]] += 1
        
    return players