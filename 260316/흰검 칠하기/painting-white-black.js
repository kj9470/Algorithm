const MAX_SIZE = 200001; // OFFSET * 2 + 1
const OFFSET = 100000;  // 최대 이동 거리 1000 * 100 = 100000

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const commands = input.slice(1).map(line => line.split(' '));

let white = Array(MAX_SIZE).fill(0); // L방향
let black = Array(MAX_SIZE).fill(0); // R방향
let color = Array(MAX_SIZE).fill(''); // 최종 색상
let current = OFFSET;

for (let command of commands) {
    let [x, direction] = command;
    x = Number(x);

    if (direction === 'R') {
        for (let i = current; i < current + x; i++) {
            if (color[i] === 'G') continue;

            black[i] += 1;

            if (black[i] >= 2 && white[i] >= 2) {
                color[i] = 'G'
            } else {
                color[i] = 'B';
            }
        }
        current = current + x - 1;
    }
    if (direction === 'L') {
        for (let i = current; i > current - x; i--) {
            if (color[i] === 'G') continue;

            white[i] += 1;

            if (black[i] >= 2 && white[i] >= 2) {
                color[i] = 'G';
            } else {
                color[i] = 'W'
            }
        }
        current = current - x + 1;
    }
}

let whiteCount = 0;
let blackCount = 0;
let grayCount = 0;

for (let i = 0; i < color.length; i++) {
    if (color[i] === 'G') {
        grayCount += 1;
    } else if (color[i] === 'W') {
        whiteCount += 1;
    } else if (color[i] === 'B') {
        blackCount += 1;
    }
}

console.log(whiteCount, blackCount, grayCount);
