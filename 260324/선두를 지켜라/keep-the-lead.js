const MAX_SIZE = 1000 * 1000;

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const aData = input.slice(1, n + 1).map(line => line.split(" ").map(Number));
const bData = input.slice(n + 1, n + 1 + m).map(line => line.split(" ").map(Number));

// 거리 = 속력 * 시간
let aPos = [0]
let aCurrent = 0;
for (let data of aData) {
    let [v, t] = data;

    for (let i = 0; i < t; i++) {
        aCurrent += v; // 초가 1초니까 v만 더해도 됨
        aPos.push(aCurrent);
    }
}

let bPos = [0];
let bCurrent = 0;
for (let data of bData) {
    let [v, t] = data;

    for (let i = 0; i < t; i++) {
        bCurrent += v;
        bPos.push(bCurrent);
    }
}

let lead = '';
let answer = 0;
for (let i = 0; i < aPos.length; i++) {
    let currentLead = '';

    if (aPos[i] > bPos[i]) {
        currentLead = 'A';
    } else if (aPos[i] < bPos[i]) {
        currentLead = 'B';
    } else {
        currentLead = '';
    }

    if (lead !== '' && currentLead !== lead) {
        answer += 1;
    }
    lead = currentLead;
}

console.log(answer);