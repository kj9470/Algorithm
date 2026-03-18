const OFFSET = 1000;
const MAX_SIZE = 2001;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const rectA = input[0].split(' ').map(Number);
const rectB = input[1].split(' ').map(Number);
const rectM = input[2].split(' ').map(Number);

let grid = Array.from({ length: MAX_SIZE }, () => Array(MAX_SIZE).fill(0));
let [ax1, ay1, ax2, ay2] = rectA;
let [bx1, by1, bx2, by2] = rectB;
let [mx1, my1, mx2, my2] = rectM;

ax1 = Number(ax1) + OFFSET;
ay1 = Number(ay1) + OFFSET;
ax2 = Number(ax2) + OFFSET;
ay2 = Number(ay2) + OFFSET;
bx1 = Number(bx1) + OFFSET;
by1 = Number(by1) + OFFSET;
bx2 = Number(bx2) + OFFSET;
by2 = Number(by2) + OFFSET;
mx1 = Number(mx1) + OFFSET;
my1 = Number(my1) + OFFSET;
mx2 = Number(mx2) + OFFSET;
my2 = Number(my2) + OFFSET;

// x1, y1 ~ x2 -1, y2 -1 

for (let i = ax1; i < ax2; i++) {
    for (let j = ay1; j < ay2; j++) {
        grid[i][j] = 1;
    }
}

for (let i = bx1; i < bx2; i++) {
    for (let j = by1; j < by2; j++) {
        grid[i][j] = 2;
    }
}

for (let i = mx1; i < mx2; i++) {
    for (let j = my1; j < my2; j++) {
        grid[i][j] = 3;
    }
}

let answer = 0;
for (let i = 0; i < MAX_SIZE; i++) {
    for (let j = 0; j < MAX_SIZE; j++) {
        if (grid[i][j] === 1 || grid[i][j] === 2) {
            answer += 1;
        }
    }
}

console.log(answer);