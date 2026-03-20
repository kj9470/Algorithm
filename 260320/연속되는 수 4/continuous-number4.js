const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const arr = input.slice(1, 1 + n).map(Number);

let count = 0, answer = 0;
for (let i = 0; i < arr.length; i++) {
    if (i >= 1 && arr[i - 1] < arr[i]) {
        count += 1; 
    } else {
        count = 1;
    }

    answer = Math.max(count, answer);
}

console.log(answer);