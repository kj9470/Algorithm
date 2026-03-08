const MAX_SIZE = 200;
const OFFSET = 100;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const segments = [];
for (let i = 1; i <= n; i++) {
    segments.push(input[i].split(' ').map(Number));
}

let straightLine = Array(MAX_SIZE + 1).fill(0);
for (let [start, end] of segments) {
    start += OFFSET; // 음수 인덱스 방지
    end += OFFSET;
    for (let i = start; i < end; i++) {
        straightLine[i] += 1;
    }
}

console.log(Math.max(...straightLine));