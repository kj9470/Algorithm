const OFFSET = 100;
const MAX_SIZE = 201

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

let grid = Array.from({ length: MAX_SIZE }, () => Array(MAX_SIZE).fill(''));

const n = Number(input[0]);
const rectangles = [];

for (let i = 1; i <= n; i++) {
    let [x1, y1, x2, y2] = input[i].split(' ').map(Number);

    x1 += OFFSET;
    y1 += OFFSET;
    x2 += OFFSET;
    y2 += OFFSET;

    rectangles.push([x1, y1, x2, y2]);
}

for (let i = 0; i < n; i++) {
    let [x1, y1, x2, y2] = rectangles[i];

    if (i % 2 === 1) { // 첫 번째가 인덱스 0이니까 1이어야 파란색
        for (let x = x1; x < x2; x++) {
            for (let y = y1; y < y2; y++) {
                grid[x][y] = 'B'
            }
        }
    } else {
        for (let x = x1; x < x2; x++) {
            for (let y = y1; y < y2; y++) {
                grid[x][y] = 'R'
            }
        }
    }
}

let answer = 0;
for (let i = 0; i < MAX_SIZE; i++) {
    for (let j = 0; j < MAX_SIZE; j++) {
        if (grid[i][j] === 'B') {
            answer += 1;
        }
    }
}

console.log(answer);