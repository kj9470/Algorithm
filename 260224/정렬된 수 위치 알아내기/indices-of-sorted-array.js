class Sequence {
    constructor(number, index) {
        this.number = number;
        this.index = index;
    }
}

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const arr = input[1].split(' ').map(Number);

let numbers = [];
for (let i = 0; i < arr.length; i++) {
    numbers.push(new Sequence(arr[i], i))
}

let answer = [];
numbers.sort((a, b) => {
    if (a.number === b.number) return a.index - b.index;
    return a.number - b.number;
})

for (let i = 0; i < arr.length; i++) {
    answer[numbers[i].index] = i + 1;
}

console.log(answer.join(' '));