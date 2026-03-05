const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const binaryInput = input[0];

const toDigit = (binary) => {
    let digit = 0;

    for (let i = 0; i < binary.length; i++) {
        digit = digit * 2 + Number(binary[i]);
    }

    return digit;
}

const toBinary = (digit) => {
    let binary = '';

    while (true) {
        if (digit < 2) {
            binary += digit;
            break;
        }

        binary += digit % 2;
        digit = Math.floor(digit / 2);
    }

    return binary.split('').reverse().join('');
}

let digit = toDigit(binaryInput.split('')) * 17;

let answer = toBinary(digit);

console.log(answer);