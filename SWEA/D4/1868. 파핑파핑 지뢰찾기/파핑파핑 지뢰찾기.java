import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int count;
    static boolean[][] v;

    static void findZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean flag = true;
                if (map[i][j] == '*') continue;
                for (int d = 0; d < 8; d++) {
                    int x = dx[d] + i;
                    int y = dy[d] + j;
                    if (!checkMap(x, y)) continue;
                    if (map[x][y] == '*') flag = false;
                }
                if (flag) map[i][j] = '0';
            }
        }
    }

    static void bfs(int startX, int startY) {
        Deque<int[]> q = new ArrayDeque();
        q.offer(new int[] {startX, startY});
        v[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] qq = q.poll();
            int x = qq[0]; int y = qq[1];
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (!checkMap(nx, ny)) continue;
                if (v[nx][ny]) continue;
                if (map[nx][ny] == '0') {
                    q.offer(new int[]{nx, ny});
                    v[nx][ny] = true;
                } else if (map[nx][ny] == '.') {
                    v[nx][ny] = true;
                }
            }
        }
    }

    static int checkNum() {
        int n = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != '*' && !v[i][j]) n++;
            }
        }
        return n;
    }

    static boolean checkMap(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            v = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            count = 0;
            findZero();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '0' && !v[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            count += checkNum();
            System.out.println("#" + t + " " + count);
        }
    }
}