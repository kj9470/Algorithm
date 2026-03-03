const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [m1, d1, m2, d2] = input[0].split(' ').map(Number);

const dates = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

const calculateDates = (month, day) => {
    let totalDays = 0;

    for (let i = 1; i < month; i++) {
        totalDays += dates[i];
    }

    totalDays += day;

    return totalDays;
}

const daySum1 = calculateDates(m1, d1);
const daySum2 = calculateDates(m2, d2);

(daySum1 > daySum2) ? console.log(daySum1 - daySum2 + 1) : console.log(daySum2 - daySum1 + 1);
