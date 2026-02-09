import java.io.*;
import java.util.*;

public class Solution {
    static int D, W, K;
    static int[][] film;
    static int best;

    static boolean checkFilm() {
        if (K == 1) return true;

        for (int col = 0; col < W; col++) {
            int run = 1;
            int maxRun = 1;
            int prev = film[0][col];

            for (int row = 1; row < D; row++) {
                if (film[row][col] == prev) run++;
                else {
                    prev = film[row][col];
                    run = 1;
                }
                if (run > maxRun) maxRun = run;
                if (maxRun >= K) break;
            }

            if (maxRun < K) return false;
        }
        return true;
    }

    static void fillRow(int row, int val) {
        for (int j = 0; j < W; j++) film[row][j] = val;
    }

    static void restoreRow(int row, int[] backup) {
        System.arraycopy(backup, 0, film[row], 0, W);
    }

    static void dfs(int row, int used) {
        if (used >= best) return;

        // 끝까지 선택했으면 검사
        if (row == D) {
            if (checkFilm()) best = used;
            return;
        }

        // 백업
        int[] backup = film[row].clone();

        // 1) 그대로
        dfs(row + 1, used);

        // 2) A(0)
        fillRow(row, 0);
        dfs(row + 1, used + 1);
        restoreRow(row, backup);

        // 3) B(1)
        fillRow(row, 1);
        dfs(row + 1, used + 1);
        restoreRow(row, backup);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (K == 1 || checkFilm()) {
                best = 0;
            } else {
                best = D;
                dfs(0, 0);
            }

            sb.append('#').append(tc).append(' ').append(best).append('\n');
        }

        System.out.print(sb);
    }
}
