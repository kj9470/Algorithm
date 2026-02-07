import java.io.*;
import java.util.*;

public class Solution {
    static int N, L;
    static int[] scores, kal;
    static int maxScore = -1;

    static void dfs(int recentKal, int score, int index) {
        if (recentKal > L) {
            return;
        }
        if (index >= N) {
            maxScore = Math.max(score, maxScore);
            return;
        }

        dfs(recentKal + kal[index], score + scores[index], index + 1);
        dfs(recentKal, score, index + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            scores = new int[N];
            kal = new int[N];
            maxScore = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                kal[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0, 0);
            System.out.println("#" + t + " " + maxScore);
        }
    }
}
