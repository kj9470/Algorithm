const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);
const movesA = input.slice(1, 1 + n);
const movesB = input.slice(1 + n, 1 + n + m);

let posA = [0];
let posB = [0];

let currentA = 0;
let currentB = 0;
let timeA = 0;
let timeB = 0;

for (let move of movesA) {
    let [t, d] = move.split(' ');
    timeA += t;

    for (let i = 0; i < t; i++) {
        if (d === 'R') {
            currentA += 1
        } else if (d === 'L') {
            currentA -= 1;
        }

        posA.push(currentA);
    }
}

for (let move of movesB) {
    let [t, d] = move.split(' ');
    timeB += t;

    for (let i = 0; i < t; i++) {
        if (d === 'R') {
            currentB += 1
        } else if (d === 'L') {
            currentB -= 1;
        }

        posB.push(currentB);
    }
}



let answer = 0;
let totalTime = Math.max(timeA, timeB);

// 시간이 다를 경우 부족한 쪽에서 마지막 위치로 채워줘야 함
while(posA.length <= totalTime) {
    posA.push(posA[posA.length - 1]);
}

while(posB.length <= totalTime) {
    posB.push(posB[posB.length - 1]);
}

for (let i = 0; i < totalTime; i++) {
    if (i >= 1 && posA[i - 1] !== posB[i - 1] && posA[i] === posB[i]) {
        answer += 1;
    }
}

console.log(answer);