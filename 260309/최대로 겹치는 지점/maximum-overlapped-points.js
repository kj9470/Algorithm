const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const segments = [];
for (let i = 1; i <= n; i++) {
  segments.push(input[i].split(' ').map(Number));
}

let answer = Array(101).fill(0);

for (let [x1, x2] of segments) {
  for (let i = x1; i <= x2; i++) {
    answer[i] += 1;
  }
}

console.log(Math.max(...answer))