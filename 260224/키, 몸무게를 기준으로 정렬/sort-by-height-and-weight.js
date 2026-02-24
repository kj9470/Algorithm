const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const n = Number(input[0]);

class Person {
    constructor(name, height, weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

const cmp = (a, b) => {
    if (a.height === b.height) {
        return b.weight - a.weight;
    }

    return a.height - b.height;
}

const personList = [];
for (let i = 1; i <= n; i++) {
    const [name, height, weight] = input[i].split(" ");
    personList[i - 1] = new Person(name, Number(height), Number(weight));
}

personList.sort(cmp);

for (let i = 0; i < n; i++) {
    console.log(`${personList[i].name} ${personList[i].height} ${personList[i].weight}`);
}