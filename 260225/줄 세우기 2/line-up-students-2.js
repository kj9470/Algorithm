class Student {
    constructor (height, weight, index) {
        this.height = height;
        this.weight = weight;
        this.index = index;
    }
}

const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);

const students = [];
for (let i = 1; i <= n; i++) {
    const [height, weight] = input[i].split(' ').map(Number);
    students[i - 1] = new Student(height, weight, i);
}

students.sort((a, b) => {
    if (a.height === b.height) return b.weight - a.weight;
    return a.height - b.height;
})

for (let i = 0; i < students.length; i++) {
    console.log(`${students[i].height} ${students[i].weight} ${students[i].index}`);
}