const OFFSET = 100;
const MAX_SIZE = OFFSET * 2 + 1;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const rects = input.slice(1, 1 + n).map(line => line.split(' ').map(Number));
const grid = Array.from({ length: MAX_SIZE }, () => Array(MAX_SIZE).fill(0));

for (let rect of rects) {
    let [x1, y1] = rect;
    x1 = Number(x1) + OFFSET;
    y1 = Number(y1) + OFFSET;

    for (let i = x1; i < x1 + 8; i++) {
        for (let j = y1; j < y1 + 8; j++) {
            grid[i][j] = 1;
        }
    }
}

let answer = 0;
for (let i = 0; i < MAX_SIZE; i++) {
    for (let j = 0; j < MAX_SIZE; j++) {
        if (grid[i][j] === 1) {
            answer += 1;
        }
    }
}

console.log(answer);