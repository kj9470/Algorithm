import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[][] map;
    static int maxResult;

    static int countHome(int k, int x, int y) {
        int home = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(x - i) + Math.abs(y - j) < k) {
                    if (!check(i, j)) continue;
                    if (map[i][j] == 1) {
                        home++;
//                        System.out.println(i + " " + j + "??" + map[i][j]);
                    }
                }
            }
        }
        return home;
    }

    static boolean check(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int home, result;
            maxResult = Integer.MIN_VALUE;
            for (int k = N * 2; k >= 1; k--) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        home = countHome(k, i, j);
                        result = (M * home) - (k * k + (k - 1) * (k - 1));
                        if (result >= 0) maxResult = Math.max(maxResult, home);
//                        System.out.println(home +" " + result);
                    }
                }
            }
            System.out.println("#" + t + " " + maxResult);
        }
    }
}