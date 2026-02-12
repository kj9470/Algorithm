import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int maxCount;
    static int roomNum;

    static int dfs(int x, int y, int roomNum) {
        visited[x][y] = true;
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == roomNum + 1) {
                    count = dfs(nx, ny, roomNum + 1) + count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            maxCount = Integer.MIN_VALUE;
            roomNum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    int c = dfs(i, j, map[i][j]);
                    if (c > maxCount) {
                        roomNum = map[i][j];
                        maxCount = c;
                    } else if (c == maxCount) {
                        if (roomNum > map[i][j]) roomNum = map[i][j];
                    }
                }
            }
            System.out.println("#" + tc + " " + roomNum + " " + maxCount);
        }
    }
}
