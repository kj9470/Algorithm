const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [A, B, C] = input[0].split(' ').map(Number);

const diff = ((A - 11) * 24 * 60 + (B - 11) * 60 + (C - 11));

if (diff <= 0) {
    console.log(-1);
} else {
    console.log(diff);
}