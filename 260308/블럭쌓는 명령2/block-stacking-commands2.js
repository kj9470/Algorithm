const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const [n, k] = input[0].split(' ').map(Number);
const segments = input.slice(1, k + 1).map(line => line.split(' ').map(Number));

let seq = Array(n).fill(0);

for ([start, end] of segments) {
    for (let i = start; i <= end; i++) {
        seq[i] += 1;
    }
}

console.log(Math.max(...seq))