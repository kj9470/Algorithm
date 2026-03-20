const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const arr = input.slice(1, n + 1).map(Number);

// 이전 숫자랑 비교해서 부호가 같으면 (곱해서 양수) ++
let count = 0;
let answer = 0;
for (let i = 0; i < arr.length; i++) {
    if (i >= 1 && arr[i] * arr[i - 1] > 0) {
        count += 1;
    } else {
        count = 1;
    }

    answer = Math.max(count, answer); // 갱신 해줘야 최댓값 저장가능
}
console.log(answer);