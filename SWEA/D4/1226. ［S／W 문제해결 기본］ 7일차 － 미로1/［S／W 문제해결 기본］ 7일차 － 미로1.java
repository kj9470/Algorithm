import java.io.*;
import java.util.*;

public class Solution {

    private static final int N = 16;
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static int[][] map;
    private static boolean[][] visited;

    private static boolean bfs(int sx, int sy) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + DX[d];
                int ny = y + DY[d];

                if (!inRange(nx, ny) || visited[nx][ny]) continue;

                if (map[nx][ny] == 3) return true;
                if (map[nx][ny] != 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return false;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int[] findStart() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) return new int[]{i, j};
            }
        }
        return new int[]{1, 1};
    }

    private static void readMap(BufferedReader br) throws IOException {
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int T = 10;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            br.readLine();

            readMap(br);
            visited = new boolean[N][N];

            int[] start = findStart();
            boolean result = bfs(start[0], start[1]);

            sb.append('#').append(tc).append(' ')
              .append(result ? 1 : 0).append('\n');
        }

        System.out.print(sb.toString());
    }
}
