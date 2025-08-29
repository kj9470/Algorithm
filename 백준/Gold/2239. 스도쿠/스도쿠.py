import sys
sys.setrecursionlimit(10**6)

puzzle = []
for i in range(9):
    puzzle.append(list(map(int, input().strip())))

row_used = [[False] * 10 for _ in range(9)]
col_used = [[False] * 10 for _ in range(9)]
box_used = [[False] * 10 for _ in range(9)]
empty = []

for i in range(9):
    for j in range(9):
        number = puzzle[i][j]
        if number == 0:
            empty.append((i, j))
        else:
            box_number = (i // 3) * 3 + (j // 3)
            row_used[i][number] = col_used[j][number] = box_used[box_number][number] = True

def solve_sudoku(idx) -> bool:
    if idx == len(empty):
        return True

    row, col = empty[idx]
    box = (row // 3) * 3 + (col // 3)

    for i in range(1, 10):
        if row_used[row][i] or col_used[col][i] or box_used[box][i]:
            continue
        puzzle[row][col] = i
        row_used[row][i] = col_used[col][i] = box_used[box][i] = True

        if solve_sudoku(idx + 1):
            return True

        puzzle[row][col] = 0
        row_used[row][i] = col_used[col][i] = box_used[box][i] = False

    return False

solve_sudoku(0)

for i in range(9):
    print(''.join(map(str, puzzle[i])))