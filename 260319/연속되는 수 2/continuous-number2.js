const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const arr = input.slice(1, n + 1).map(Number);

let count = 1;
for (let i = 1; i < arr.length; i++) {
    if (arr[i] != arr[i - 1]) {
        count += 1;
    }
}

console.log(count);