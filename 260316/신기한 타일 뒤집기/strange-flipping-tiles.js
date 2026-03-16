const MAX_SIZE = 200001
const OFFSET = 100000

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const commands = input.slice(1);

let color = Array(MAX_SIZE).fill('');
let current = OFFSET;

for (let command of commands) {
    let [x, direction] = command.split(' ');
    x = Number(x);

    if (direction === 'R') {
        for (let i = current; i < current + x; i++) {
            color[i] = 'B';
        }
        current = current + x - 1;
    } else if (direction === 'L') {
        for (let i = current; i > current - x; i--) {
            color[i] = 'W';
        }
        current = current - x + 1;
    }
}


let blackCount = 0;
let whiteCount = 0;
for (let i = 0; i < color.length; i++) {
    if (color[i] === 'B') {
        blackCount += 1;
    } else if (color[i] === 'W') {
        whiteCount += 1;
    }
}

console.log(whiteCount, blackCount);