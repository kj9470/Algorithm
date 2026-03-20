const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const [n, m] = input[0].split(' ').map(Number);
let line = 1;
const movesA = [];
for (let i = 0; i < n; i++) {
    const [d, t] = input[line++].split(' ');
    movesA.push([d, Number(t)]);
}

const movesB = [];
for (let i = 0; i < m; i++) {
    const [d, t] = input[line++].split(' ');
    movesB.push([d, Number(t)]);
}

let posA = [0];
let curA = 0;
for (let i = 0; i < movesA.length; i++) {
    let [d, t] = movesA[i];

    for (let j = 0; j < t; j++) {
        // 현재 위치 갱신
        if (d === 'R') {
            curA += 1;
        } else {
            curA -= 1;
        }

        // 현재 위치 저장
        posA.push(curA);
    }
}

let posB = [0];
let curB = 0;
for (let i = 0; i < movesB.length; i++) {
    let [d, t] = movesB[i];

    for (let j = 0; j < t; j++) {
        // 현재 위치 갱신
        if (d === 'R') {
            curB += 1;
        } else {
            curB -= 1;
        }

        // 현재 위치 저장
        posB.push(curB);
    }
}

let answer = -1;
for (let i = 1; i < posA.length; i++) {
    if (posA[i] === posB[i]) {
        answer = i; // 시간은 i
        break;
    }
}

console.log(answer);