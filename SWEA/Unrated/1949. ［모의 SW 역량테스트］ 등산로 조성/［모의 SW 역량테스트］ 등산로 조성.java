import java.io.*;
import java.util.*;

public class Solution {
    static int N, K;
    static int[][] map;
    static ArrayList<int[]> highs;
    static int hIdx;
    static int maxHigh;
    static boolean[][] v;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean outArea(int x, int y, int N) {
        if (x < 0 || x >= N || y < 0 || y >= N) return true;
        return false;
    }
    static int maxCount;

    static void dfs(int x, int y, int curH, int count, boolean used) {
        v[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d]; int ny = y + dy[d];
            if (outArea(nx, ny, N)) continue;
            int nextH = map[nx][ny];
            if (v[nx][ny]) continue;
            if (nextH < curH) {
                v[nx][ny] = true;
                dfs(nx, ny, nextH, count + 1, used);
                v[nx][ny] = false;
            } else if (!used) {
                for (int k = 1; k <= K; k++) {
                    if (nextH - k < curH) {
                        v[nx][ny] = true;
                        dfs(nx, ny, nextH - k, count + 1, true);
                        v[nx][ny] = false;
                    }
                }
            }
        }
        v[x][y] = false;
        maxCount = Math.max(count, maxCount);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            hIdx = 0; maxHigh = Integer.MIN_VALUE; highs = new ArrayList<>();
            map = new int[N][N];
            v = new boolean[N][N];
            maxCount = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > maxHigh) {
                        highs = new ArrayList<>();
                        highs.add(new int[]{i, j});
                        maxHigh = map[i][j];
                    } else if (map[i][j] == maxHigh) {
                        highs.add(new int[]{i, j});
                        maxHigh = map[i][j];
                    }
                }
            }

            for (int i = 0; i < highs.size(); i++) {
                int[] h = highs.get(i);
                int x = h[0]; int y = h[1];
                dfs(x, y, map[x][y], 1, false);
            }
            System.out.println("#" + t + " " + maxCount);
        }
    }
}