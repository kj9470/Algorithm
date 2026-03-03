const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");
const [m1, d1, m2, d2] = input[0].split(" ").map(Number);

const days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
const date = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];

let diff = 0;

if (m1 === m2) {
    diff = d2 - d1;
} else {
    // 시작 달
    diff += (days[m1] - d1);

    for (let m = m1 + 1; m <= m2 - 1; m++) {
        diff += days[m];
    }

    // 끝나는 달
    diff += d2;
}

const answer = date[((diff % 7) + 7) % 7];
console.log(answer);
