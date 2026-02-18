import java.io.*;
import java.util.*;

public class Solution {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static Point company;
    static Point home;
    static Point[] customers;
    static boolean[] v;
    static int minDistance;

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void dfs(int total, Point recent, int count) {
//        System.out.println(total + " " + recent + " " + count);
        if (count == N) {
            total += distance(recent.x, recent.y, home.x, home.y);
            minDistance = Math.min(total, minDistance);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                Point next = customers[i];
                dfs(total + distance(recent.x, recent.y, next.x, next.y), next, count + 1);
                v[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int x, y;
            v = new boolean[N];
            customers = new Point[N];
            minDistance = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            company = new Point(x, y);
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            home = new Point(x, y);
            for (int i = 0; i < N; i++) {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                customers[i] = new Point(x, y);
            }
            dfs(0, company, 0);
            System.out.println("#" + t + " " + minDistance);
        }
    }
}