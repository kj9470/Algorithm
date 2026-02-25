class Sequence {
    constructor(number, index) {
        this.number = number;
        this.index = index;
    }
}

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const arr = input[1].split(' ').map(Number);

let numbers = []
for (let i = 0; i < arr.length; i++) {
    numbers.push(new Sequence(arr[i], i));
}


numbers.sort((a, b) => {
    if (a.number === b.number) return a.index - b.index; // 순서 보장
    return a.number - b.number;
})

let answer = []; // 정답 배열
for (let i = 0; i < arr.length; i++) {
    answer[numbers[i].index] = i + 1; // 이동한 만큼이니까 + 1해줌
}

console.log(answer.join(' '));