const MAX_SIZE = 200;
const OFFSET = 100;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const commands = input.slice(1).map(line => line.split(' '));

let arr = Array(MAX_SIZE).fill(0);
let current = 0;

for (let command of commands) {
    let [x, direction] = command.split(' ');
    x = Number(x);
    x += OFFSET;

    if (direction === 'R') {
        for (let i = current; i <= x + current; i++) {
            arr[i].push('B');
        }
    } else if (direction === 'L') {
        for (let i = current; i >= current - x; i--) {
            arr[i].push('W');
        }
    }
}


let grayCount = 0;
for (let i = 0; i < arr.length; i++) {
    let blackCount = arr.filter((color) => color === 'B').length;
    let whiteCount = arr.filter((color) => color === 'W').length;

    if (blackCount >= 2 && whiteCount >= 2) {
        grayCount += 1;
    } else if (arr[i].includes('B')) {
        blackCount += 1;
    } else if (arr[i].includes('W')) {
        whiteCount += 1;
    }
}

console.log(whiteCount, blackCount, grayCount);