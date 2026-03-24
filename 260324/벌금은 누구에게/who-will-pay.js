const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const [n, m, k] = input[0].split(" ").map(Number);
const penalizedPersons = input.slice(1, m + 1).map(Number);

const persons = Array.from({ length: n + 1 }, () => 0);

let answer = -1;
for (let penaltyNum of penalizedPersons) {
    persons[penaltyNum] += 1;

    for (let i = 0; i < n; i++) {
        if (persons[i] >= k) {
            answer = i;
            break;
        }
    }
}

console.log(answer);