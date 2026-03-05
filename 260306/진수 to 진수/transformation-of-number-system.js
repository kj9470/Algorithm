const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const [a, b] = input[0].split(' ').map(Number);
const n = input[1];

const toDigit = (a, num) => {
    let digit = 0;
    num = num.toString();

    for (let i = 0; i < num.length; i++) {
        digit = digit * a + Number(num[i]);
    }

    return digit;
}

const toNary = (b, num) => {
    let nary = '';

    while (true) {
        if (num < b) {
            nary += num;
            break;
        }

        nary += num % b;
        num = Math.floor(num / b);
    }

    return nary.split('').reverse().join('');
}   

let digit = toDigit(a, n);
let answer = toNary(b, digit);

console.log(answer);