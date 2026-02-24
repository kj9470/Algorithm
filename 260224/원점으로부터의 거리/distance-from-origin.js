const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);

class Point {
    constructor(x, y, idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

const compareDistance = (a, b) => {
    let distA = Math.abs(0 - a.x) + Math.abs(0 - a.y);
    let distB = Math.abs(0 - b.x) + Math.abs(0 - b.y);

    return distA - distB;
}

const points = [];
for (let i = 1; i < n + 1; i++) {
    let [x, y] = input[i].split(' ').map(Number);
    points[i - 1] = new Point(x, y, i);
}

points.sort(compareDistance);

for (let i = 0; i < n; i++) {
    console.log(`${points[i].idx}`);
}