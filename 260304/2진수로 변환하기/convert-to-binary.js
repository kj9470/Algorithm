const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
let n = Number(input[0]);

let digits = [];

while (true) {
    if (n < 2) {
        digits.push(n);
        break;
    }

    digits.push(n % 2);
    n = Math.floor(n / 2);
}

let binary = '';
for (let i = digits.length - 1; i >= 0; i--) {
    binary += digits[i];
}

console.log(binary);