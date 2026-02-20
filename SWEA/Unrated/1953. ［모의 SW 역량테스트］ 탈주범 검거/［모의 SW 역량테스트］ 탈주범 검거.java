import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, R, C, L;
    static int[][] map;
    static int[][] tunnels = { // 상하좌우
            {},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 0}
    };
    static int[] isConn = {1, 0, 3, 2}; // 상하좌우 와 연결되어야 하기에 하상우좌 index 번호
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static boolean[][] v;

    static void bfs(int R, int C, int count) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{R, C, count});
        v[R][C] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0]; int c = p[1]; int pipe = map[r][c]; int recentCount = p[2];
            if (pipe == 0) continue;
            if (recentCount == L) continue;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (v[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;
                if (tunnels[pipe][d] == 0) continue;
                if (tunnels[map[nr][nc]][isConn[d]] == 0) continue;
                q.offer(new int[]{nr, nc, recentCount + 1});
                v[nr][nc] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            v = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs(R, C, 1);

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (v[i][j]) result++;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
