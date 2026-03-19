const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const arr = input.slice(1, n + 1).map(Number);

let count = 0, answer = 0;
for (let i = 0; i < arr.length; i++) {
    if (i === 0) {
        count = 1;
    }

    if (i >= 1 && arr[i] != arr[i - 1]) {
        count += 1;
    }
    answer = Math.max(count, answer)
}

console.log(answer);