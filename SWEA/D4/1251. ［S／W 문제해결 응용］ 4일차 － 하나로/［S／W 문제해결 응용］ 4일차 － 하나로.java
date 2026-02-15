import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] xIsland, yIsland;
    static double E;
    static boolean[] v;
    static double[] P;

    static double environmentalFee(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        double distance = (double) dx * dx + (double) dy * dy;
        return E * distance;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            xIsland = new int[N];
            yIsland = new int[N];
            v = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                xIsland[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                yIsland[j] = Integer.parseInt(st.nextToken());
            }
            E = Double.parseDouble(br.readLine());

            P = new double[N]; Arrays.fill(P, Double.MAX_VALUE);
            Double mst = 0.0;
            int cnt = 0;
            P[0] = 0;
            for (int i = 0; i < N; i++) {
                int minVertex = -1;
                Double minCost = Double.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!v[j] && minCost > P[j]) {
                        minCost = P[j]; minVertex = j;
                    }
                }
                v[minVertex] = true;
                mst += minCost;
                if (cnt++ == N - 1) break;
                for (int j = 0; j < N; j++) {
                    if (v[j]) continue;
                    Double cost = environmentalFee(xIsland[minVertex], yIsland[minVertex], xIsland[j], yIsland[j]);
                    if (cost < P[j]) P[j] = cost;
                }
            }
            System.out.println("#" + t + " " + Math.round(mst));
        }
    }
}
