import java.io.*;
import java.util.*;

public class Solution {
    static int N, B;
    static ArrayList<Integer> height;
    static int sum;
    static int result;

    static void dfs(int recentHeight, int index) {
//        System.out.println(recentHeight + " " + B + " " + index + " " + height.get(index));
        if (index == N) {
            if (recentHeight >= B) result = Math.min(recentHeight - B, result);
            return;
        }
        if (recentHeight < B) {
            return;
        }
        result = Math.min(recentHeight - B, result);

        dfs(recentHeight - height.get(index), index + 1);
        dfs(recentHeight, index + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sum = 0;
            height = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int h = Integer.parseInt(st.nextToken());
                height.add(h);
                sum += h;
            }

            result = 10000;
            Collections.sort(height);

            dfs(sum, 0);
            System.out.println("#" + tc + " " + result);
        }
    }
}
