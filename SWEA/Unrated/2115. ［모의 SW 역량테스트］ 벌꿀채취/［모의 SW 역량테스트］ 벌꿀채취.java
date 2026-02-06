import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, C;
    static int[][] map, maxMap;

    private static int getMaxBenefit() {
        makeMaxMap();
        return processCombination();
    }

    private static void makeMaxMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                subset(i, j, 0, 0, 0);
            }
        }
    }

    private static int processCombination() {
        int aBenefit, bBenefit, max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                aBenefit = maxMap[i][j];

                bBenefit = 0;
                for (int i2 = i; i2 < N; i2++) {
                    int start = (i2 == i) ? j + M : 0;
                    for (int j2 = start; j2 <= N - M; j2++) {
                        if (bBenefit < maxMap[i2][j2]) {
                            bBenefit = maxMap[i2][j2];
                        }
                    }
                }
                if (max < aBenefit + bBenefit) {
                    max = aBenefit + bBenefit;
                }
            }
        }
        return max;
    }

    private static void subset(int i, int j, int cnt, int sum, int powSum) {
        if (sum > C) return;
        if (cnt == M) {
            if (maxMap[i][j - M] < powSum) maxMap[i][j - M] = powSum;
            return;
        }

        // 벌통 포함
        subset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);
        // 벌통 미포함
        subset(i, j + 1, cnt + 1, sum, powSum);
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int [N][N];
            maxMap = new int [N][N - M + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + t + " " + getMaxBenefit());
        }
    }
}
