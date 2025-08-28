N = int(input())

def count_queen(n):
    def is_valid(queen_positions, row, col):
        for r, c in enumerate(queen_positions):
            if c == col or abs(c - col) == abs(r - row):
                return False
        return True

    def backtrack(queen_positions):
        nonlocal count
        if len(queen_positions) == n:
            count += 1
            return

        for col in range(n):
            if is_valid(queen_positions, len(queen_positions), col):
                queen_positions.append(col)
                backtrack(queen_positions)
                queen_positions.pop()

    count = 0
    backtrack([])
    return count

print(count_queen(N))