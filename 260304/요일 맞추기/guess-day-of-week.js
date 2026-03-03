const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");
const [m1, d1, m2, d2] = input[0].split(" ").map(Number);

const days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
const date = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];

const convertToDays = (m, d) => {
    let totalDays = 0;

    for (let i = 1; i < m; i++) {
        totalDays += days[i];
    }

    totalDays += d;

    return totalDays;
}

let days1 = convertToDays(m1, d1);
let days2 = convertToDays(m2, d2);

let diff = days2 - days1;
while (diff < 0) {
    diff += 7;
}
 
console.log(date[diff % 7]);