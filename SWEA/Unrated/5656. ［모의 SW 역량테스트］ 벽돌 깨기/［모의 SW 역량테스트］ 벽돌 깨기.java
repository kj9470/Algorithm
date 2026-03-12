import java.io.*;
import java.util.*;

public class Solution {
    static int N, W, H;
    static int[][] map;
    static Deque<Integer> stack;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;

    static void breakBrick(int[][] map, int sx, int sy, int sn) {
        Deque<int[]> q = new ArrayDeque<>();

        if (sn > 1) {
            q.offer(new int[]{sx, sy, sn});
        }
        map[sx][sy] = 0;

        int x, y, n;
        while(!q.isEmpty()) {
            int[] dq = q.poll();
            x = dq[0]; y = dq[1]; n = dq[2];
            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;
                for (int i = 1; i < n; i++) {
                    nx += dx[d]; ny += dy[d];
                    if (!check(nx, ny)) break;
                    if (map[nx][ny] == 0) continue;
                    if (map[nx][ny] > 1) {
                        q.offer(new int[]{nx, ny, map[nx][ny]});
                    }
                    map[nx][ny] = 0;
                }
            }
        }
    }

    static void down(int[][] map) {
        stack = new ArrayDeque<>();
        for (int w = 0; w < W; w++) {
            for (int h = 0; h < H; h++) {
                if (map[h][w] != 0) {
                    stack.push(map[h][w]);
                }
            }
            for (int h = 0; h < H; h++) {
                map[h][w] = 0;
            }
            int row = H - 1;
            int brick;
            while(!stack.isEmpty()) {
                brick = stack.pop();
                map[row][w] = brick;
                row--;
            }
        }
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    static int count(int[][] arr) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] > 0) count++;
            }
        }
        return count;
    }

    static int find(int[][] arr, int j) {
        for (int i = 0; i < H; i++) {
            if (arr[i][j] > 0) return i;
        }
        return -1;
    }

    static int[][] copyMap(int[][] arr) {
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            newMap[i] = arr[i].clone();
        }
        return newMap;
    }

    static void dfs(int depth, int[][] arr) {
        int c = count(arr);
        if (c == 0) {
            result = 0;
            return;
        }

        if (depth == N) {
            result = Math.min(result, c);
            return;
        }

        for (int j = 0; j < W; j++) {
            int i = find(arr, j);
            if (i == -1) {
                dfs(depth + 1, arr);
                continue;
            }
            int[][] newArr = copyMap(arr);
            breakBrick(newArr, i, j, newArr[i][j]);
            down(newArr);
            dfs(depth + 1, newArr);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MAX_VALUE;
            dfs(0, map);
            System.out.println("#" + t + " " + result);
        }
    }
}