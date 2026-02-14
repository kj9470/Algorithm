import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static int startX = 0, startY = 0;
    static int endX, endY = 0;
    static int[][] v;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, startY, startX});
        v[startY][startX] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int y = cur[1];
            int x = cur[2];

            if (cost != v[y][x]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    int currentCost = cost + map[ny][nx];
//                    System.out.println(Arrays.deepToString(v)+ " " + ny + " " + nx + currentCost);
                    if (currentCost < v[ny][nx]) {
                        v[ny][nx] = currentCost;
                        pq.offer(new int[]{currentCost, ny, nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            v = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    v[i][j] = Integer.MAX_VALUE;
                }
            }
            endX = endY = N - 1;
            for (int i = 0; i < N; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            dijkstra();
//            System.out.println(Arrays.deepToString(v));
            System.out.println("#" + t + " " + v[endY][endX]);
        }
    }
}
