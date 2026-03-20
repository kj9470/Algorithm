const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [n, t] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

let count = 0, answer = 0;
for (let i = 0; i < arr.length; i++) {
    if (i >= 1 && arr[i - 1] > t && arr[i] > t) {
        count += 1;
    } else if (arr[i] > t) {
        count = 1;
    } else {
        count = 0;
    }

    answer = Math.max(count, answer);
}

console.log(answer);