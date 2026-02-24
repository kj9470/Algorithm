import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[] deserts;
    static boolean[][] v;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static int startX = 0, startY = 0;
    static int maxCount;

    static void dfs(int x, int y, int r, int count, int turnCount) {
        deserts[map[x][y]] = true;
        v[x][y] = true;

        for (int d = r; d <= r + 1 && d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == startX && ny == startY && count >= 4) {
                maxCount = Math.max(count, maxCount);
                continue;
            }
            if (!checkMap(nx, ny)) continue;
            if (v[nx][ny]) continue;
            if (deserts[map[nx][ny]]) continue;
            dfs(nx, ny, d, count + 1, turnCount);
        }
        v[x][y] = false;
        deserts[map[x][y]] = false;
    }

    static boolean checkMap(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            maxCount = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N - 1; j++) {
                    startX = i; startY = j;
                    v = new boolean[N][N];
                    deserts = new boolean[101];
//                    System.out.println(i + " " + j + " start");
                    dfs(startX, startY, 0, 1, 0);
                }
            }
            if (maxCount == Integer.MIN_VALUE) {
                System.out.println("#" + t + " " + -1);
            } else {
                System.out.println("#" + t + " " + maxCount);
            }
        }
    }
}