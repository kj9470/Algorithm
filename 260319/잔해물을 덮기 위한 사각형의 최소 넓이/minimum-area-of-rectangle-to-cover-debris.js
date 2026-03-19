const OFFSET = 1000;
const MAX_SIZE = OFFSET * 2 + 1;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const rect1 = input[0].split(' ').map(Number);
const rect2 = input[1].split(' ').map(Number);

let grid = Array.from({ length: MAX_SIZE }, () => Array(MAX_SIZE).fill(0));

let [rect1X1, rect1Y1, rect1X2, rect1Y2] = rect1;
let [rect2X1, rect2Y1, rect2X2, rect2Y2] = rect2;

rect1X1 = Number(rect1X1) + OFFSET;
rect1X2 = Number(rect1X2) + OFFSET;
rect1Y1 = Number(rect1Y1) + OFFSET;
rect1Y2 = Number(rect1Y2) + OFFSET;

rect2X1 = Number(rect2X1) + OFFSET;
rect2X2 = Number(rect2X2) + OFFSET;
rect2Y1 = Number(rect2Y1) + OFFSET;
rect2Y2 = Number(rect2Y2) + OFFSET;

for (let x = rect1X1; x < rect1X2; x++) {
    for (let y = rect1Y1; y < rect1Y2; y++) {
        grid[x][y] = 1;
    }
}

for (let x = rect2X1; x < rect2X2; x++) {
    for (let y = rect2Y1; y < rect2Y2; y++) {
        grid[x][y] = 2;
    }
}

let minX = MAX_SIZE, minY = MAX_SIZE;
let maxX = 0, maxY = 0;
let isExist = false;
for (let i = 0; i < MAX_SIZE; i++) { // 행
    for (let j = 0; j < MAX_SIZE; j++) { // 열
        if (grid[i][j] === 1) {
            isExist = true;
            minX = Math.min(minX, i);
            minY = Math.min(minY, j);
            maxX = Math.max(maxX, i);
            maxY = Math.max(maxY, j);
        }
    }
}


let answer = 0;

if (!isExist) {
    console.log(0);
} else {
    answer = (maxX - minX + 1) * (maxY - minY + 1);
    console.log(answer);
}