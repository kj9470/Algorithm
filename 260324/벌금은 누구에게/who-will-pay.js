const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const [n, m, k] = input[0].split(" ").map(Number);
const penalizedPersons = input.slice(1, m + 1).map(Number);

const persons = Array.from({ length: n + 1 }, () => 0);

let answer = 0;
for (let penaltyNum of penalizedPersons) {
    persons[penaltyNum] += 1;

    for (let i = 1; i < n + 1; i++) {
        if (persons[i] >= k) {
            flag = true;
            answer = i;
            break;
        }
    }
}

console.log(answer);