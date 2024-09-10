def solution(s):
    result = []
    
    for i in range(1, len(s) // 2 + 1): 
        s_count = 1
        s_list = []
        
        for j in range(len(s) // i):
            if s[i * j: (j + 1) * i] == s[(j + 1) * i: (j + 2) * i]:
                s_count += 1
            else:
                if s_count != 1:
                    s_list.append(s_count)
                else:
                    s_list.append(1)
                s_count = 1  
                
        s_len = len(s)
        
        c_list = 0
        for n in s_list:
            c_list += (n - 1)  
        
        c_sum = 0
        for n in s_list:
            if n > 1:
                c_sum += len(str(n)) 
        
        result.append(s_len - i * c_list + c_sum)
    
    if result:
        return min(result)
    else:
        return 1
