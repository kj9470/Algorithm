import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int X;
    static int[][] map;

    static boolean checkRow(int x) {
        int count = 1;
        for (int y = 0; y < N - 1; y++) {
            int cur = map[x][y];
            int next = map[x][y + 1];
            if (cur == next) count++;
            else if (next - cur == 1) {
                if (count < X) return false;
                count = 1;
            }
            else if (next - cur == -1) { // 내리막
                for (int k = 1; k <= X; k++) {
                    if (y + k >= N || map[x][y + k] != next) return false;
                }
                y += X - 1;
                count = 0;
            }
            else return false;
        }
        return true;
    }

    static boolean checkCol(int y) {
        int count = 1;
        for (int x = 0; x < N - 1; x++) {
            int cur = map[x][y];
            int next = map[x + 1][y];
            if (cur == next) count++;
            else if (next - cur == 1) {
                if (count < X) return false;
                count = 1;
            }
            else if (next - cur == -1) {
                for (int k = 1; k <= X; k++) {
                    if (x + k >= N || map[x + k][y] != next) return false;
                }
                x += X - 1;
                count = 0;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                if (checkRow(i)) result++;
                if (checkCol(i)) result++;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}