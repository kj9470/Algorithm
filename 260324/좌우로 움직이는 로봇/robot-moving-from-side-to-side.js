const MAX_SIZE = 1000000;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [n, m] = input[0].split(' ').map(Number);
const movesA = input.slice(1, 1 + n);
const movesB = input.slice(1 + n, 1 + n + m);

let posA = Array.from({ length: MAX_SIZE + 1 }, () => 0);
let posB = Array.from({ length: MAX_SIZE + 1 }, () => 0);

let currentA = 0;
let currentB = 0;
let timeA = 1;
let timeB = 1;

for (let move of movesA) {
    let [t, d] = move.split(' ');
    t = Number(t);

    for (let i = 0; i < t; i++) {
        if (d === 'R') {
            currentA += 1
        } else if (d === 'L') {
            currentA -= 1;
        }

        posA[timeA] = currentA;
        timeA += 1;
    }
}

for (let move of movesB) {
    let [t, d] = move.split(' ');
    t = Number(t);

    for (let i = 0; i < t; i++) {
        if (d === 'R') {
            currentB += 1
        } else if (d === 'L') {
            currentB -= 1;
        }

        posB[timeB] = currentB;
        timeB += 1;
    }
}

// 시간이 다를 경우 부족한 쪽에서 마지막 위치로 채워줘야 함
if (timeA < timeB) {
    for (let i = timeA; i <= timeB; i++) {
        posA[i] = posA[timeA];
    }
} else if (timeA > timeB) {
    for (let i = timeB; i <= timeA; i++) {
        posB[i] = posB[timeB];
    }
}

let answer = 0;
let totalTime = Math.max(timeA, timeB);
for (let i = 1; i <= totalTime; i++) {
    if (posA[i - 1] !== posB[i - 1] && posA[i] === posB[i]) {
        answer += 1;
    }
}

console.log(answer);