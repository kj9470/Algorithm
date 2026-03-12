const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const commands = input.slice(1, n + 1);

let OFFSET = 1000;
let currentX = OFFSET;
let visited = Array(2001).fill(0);

for (let command of commands) {
    let [x, direction] = command.split(' ');
    x = Number(x);

    if (direction === 'R') {
        for (let i = currentX; i < currentX + x; i++) {
            visited[i] += 1;
        }
        currentX += x;

    } else if (direction === 'L') {
        for (let i = currentX - 1; i >= currentX - x; i--) {
            visited[i] += 1;
        }
        currentX -= x;
    }
}

let answer = 0;
for (let i = 0; i < visited.length; i++) {
    if (visited[i] >= 2) {
        answer += 1;
    }
}

console.log(answer);