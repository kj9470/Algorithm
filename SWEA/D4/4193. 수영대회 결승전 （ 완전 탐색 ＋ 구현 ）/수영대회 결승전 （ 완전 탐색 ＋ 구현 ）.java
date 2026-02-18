import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static int startX, startY, endX, endY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] v;
    static int minTime;

    static void bfs(int startX, int startY, int time) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX, time});
        v[startY][startX] = true;
        int x, y, t;

        while (!q.isEmpty()) {
            int[] m = q.poll();
            y = m[0]; x = m[1]; t = m[2];
            v[y][x] = true;
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[ny][nx]) {
                    if (ny == endY && nx == endX) {
                        minTime = Math.min(t, minTime);
                        return;
                    }
                    if (map[ny][nx] == 0) {
                        q.offer(new int[]{ny, nx, t + 1});
                    }
                    else if (map[ny][nx] == 2) { // 소용돌이
                        if (t % 3 == 2) { // 현재 지나갈 수 있음
                            q.offer(new int[]{ny, nx, t + 1});
                        } else { // 초 뒤에 지나갈 수 있음
                            q.offer(new int[]{y, x, t + 1});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            v = new boolean[N][N];
            minTime = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            startY = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            endY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());

            bfs(startX, startY, 0);
            if (minTime == Integer.MAX_VALUE) {
                minTime = -1;
            } else {
                minTime++;
            }
            System.out.println("#" + t + " " + minTime);
        }
    }
}