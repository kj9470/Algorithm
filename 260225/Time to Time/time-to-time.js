const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const [a, b, c, d] = input[0].split(' ').map(Number);

let answer = 0;

const calculateTime = (given_hour, given_min) => {
    let time = 0;
    let hour = 0;
    let min = 0;

    while (true) {
        if (hour === given_hour && min === given_min) {
            break;
        }

        time += 1;
        min += 1;

        if (min === 60) {
            hour += 1;
            min = 0;
        }
    }

    return time;
}

let ab_time = calculateTime(a, b);
let cd_time = calculateTime(c, d);

if (ab_time > cd_time) {
    console.log(ab_time - cd_time);
} else {
    console.log(cd_time - ab_time);
}