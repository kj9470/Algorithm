const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const binaryStr = input[0];

const binary = binaryStr.split('').map(Number);

let num = 0;
for (let i = 0; i < binary.length; i++) {
    num = num * 2 + binary[i];
}

console.log(num);