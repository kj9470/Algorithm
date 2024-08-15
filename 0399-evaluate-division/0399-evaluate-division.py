from collections import defaultdict

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = defaultdict(dict)
        
        for (a, b), value in zip(equations, values):
            graph[a][b] = value
            graph[b][a] = 1 / value
        
        def dfs(start, end, visited):
            if start not in graph or end not in graph:
                return -1.0
            if end in graph[start]:
                return graph[start][end]
            
            visited.add(start)
            for neighbor, weight in graph[start].items():
                if neighbor not in visited:
                    result = dfs(neighbor, end, visited)
                    if result != -1.0:
                        return result * weight
            visited.remove(start)
            return -1.0
        
        results = []
        for start, end in queries:
            if start == end:
                if start in graph:
                    results.append(1.0)
                else:
                    results.append(-1.0)
            else:
                results.append(dfs(start, end, set()))
        
        return results

        
        