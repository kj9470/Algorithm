const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const DATES_IN_MONTH = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
const DAYS_OF_YEAR = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

const [m1, d1, m2, d2] = input[0].split(' ').map(Number);
const A = input[1];

const calculateDays = (m, d) => {
    let totalDays = 0;

    for (let i = 1; i < m; i++) {
        totalDays += DAYS_OF_YEAR[i];
    }

    totalDays += d;

    return totalDays;
}

const totalDays1 = calculateDays(m1, d1);
const totalDays2 = calculateDays(m2, d2);

const diff = totalDays2 - totalDays1 + 1;

let targetIdx = DATES_IN_MONTH.indexOf(A);
let answer = Math.floor(diff / 7); // 완전한 일주일의 수

let leftover = diff % 7;
for (let i = 0; i < leftover; i++) {
    let idx = i % 7;
    if (idx === targetIdx) {
        answer += 1;
    }
}

console.log(answer);