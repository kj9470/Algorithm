const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const dates = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
const days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

const [m1, d1, m2, d2] = input[0].split(' ').map(Number);
const A = input[1];

const calculateDays = (m, d) => {
    let totalDays = 0;

    for (let i = 1; i < m; i++) {
        totalDays += days[i];
    }

    totalDays += d;

    return totalDays;
}

const totalDays1 = calculateDays(m1, d1);
const totalDays2 = calculateDays(m2, d2);

const diff = totalDays2 - totalDays1;
let dateIdx = dates.indexOf(A);

let answer = 0;
if (dateIdx > (diff % 7)) {
    answer += 1
}

answer += diff / 7;

console.log(Math.ceil(answer));