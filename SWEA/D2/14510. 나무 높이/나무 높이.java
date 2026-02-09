import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder();

            ArrayList<Integer> trees = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                trees.add(Integer.parseInt(st.nextToken()));
            }

            int maxTree = Collections.max(trees);

            int ones = 0; // 홀수 날
            int twos = 0; // 짝수 날

            for (int height: trees) { // 자라야 할 나무 높이
                int diff = maxTree - height;
                twos += diff / 2; // 필요한 최소 짝수 날 (+2)
                ones += diff % 2; // 필요한 최소 홀수 날 (+1)
            }

            // 짝수 날이 더 많을 시 홀수 날 이틀로 변환
            // ex) two가 5번, one이 1번 있을 때 배치 불가능
            // 짝수 날은 홀수 날과 같거나 1 작아야 함
            while (twos > ones + 1) {
                twos--;
                ones += 2;
            }

            int day = 0;
            // 현재 day 중 홀수날짜 (day + 1) / 2
            // 현재 day 중 짝수날짜 (day / 2)
            // ex) day가 5일 때 홀수는 3일, 짝수는 2일
            while (((day + 1) / 2 < ones || day / 2 < twos)) {
                day++;
            }

            sb.append("#").append(t).append(" ").append(day);
            System.out.println(sb);
        }
    }
}