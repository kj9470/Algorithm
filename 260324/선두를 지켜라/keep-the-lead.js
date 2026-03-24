const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const aData = input.slice(1, n + 1).map(line => line.split(" ").map(Number));
const bData = input.slice(n + 1, n + 1 + m).map(line => line.split(" ").map(Number));

// A 시간에 따른 위치 배열
let aPos = [0];
let aCurrent = 0;
for (a of aData) {
    let [v, t] = a;

    // 시간에 따른 위치 저장
    for (let i = 0; i < t; i++) {
        aCurrent += v;
        aPos.push(aCurrent);
    }
}

let bPos = [0];
let bCurrent = 0;
for (b of bData) {
    let [v, t] = b;

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
        continue;
    }

    // 선두가 바뀌었을 때
    if (lead !== '' && currentLead != lead) {
        answer += 1;
    }
    lead = currentLead;
}

console.log(answer);