const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
let [n, b] = input[0].split(' ').map(Number);

let answer = ''

while (true) {
    if (n < b) {
        answer += n;
        break;
    }

    answer += n % b;
    n = Math.floor(n / b);
}

answer = answer.split('').reverse().join('');

console.log(answer);