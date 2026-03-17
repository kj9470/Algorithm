const OFFSET = 100;
const MAX_SIZE = 100 * 10 + 1;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const rects = input.slice(1, n + 1).map(line => line.split(' ').map(Number));

let arr = Array.from({ length: MAX_SIZE }, () => new Array(MAX_SIZE).fill(0));

for (let rect of rects) {
    let [x1, y1, x2, y2] = rect;
    x1 = Number(x1) + OFFSET;
    x2 = Number(x2) + OFFSET;
    y1 = Number(y1) + OFFSET;
    y2 = Number(y2) + OFFSET;

    // x1, y1 ~ x2 - 1, y2 - 1
    for (let i = x1; i < x2; i++) {
        for (let j = y1; j < y2; j++) {
            arr[i][j] = 1;
        }
    }
}

let total_s = 0;
for (let i = 0; i < MAX_SIZE; i++) {
    for (let j = 0; j < MAX_SIZE; j++) {
        total_s += arr[i][j];
    }
}

console.log(total_s);