const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const segments = [];
for (let i = 1; i <= n; i++) {
    segments.push(input[i].split(' ').map(Number));
}

let straightLine = Array(100).fill(0);
for (let [start, end] of segments) {
    for (let i = start; i < end; i++) {
        straightLine[i] += 1;
    }
}

console.log(Math.max(...straightLine));