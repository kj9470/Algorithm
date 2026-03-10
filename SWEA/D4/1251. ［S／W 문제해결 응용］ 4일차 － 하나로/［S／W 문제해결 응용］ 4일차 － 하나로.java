import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] x;
    static int[] y;
    static double E;

    static double cost(int x1, int y1, int x2, int y2) {
        double x = x1 - x2;
        double y = y1 - y2;
        double d = (x * x) + (y * y);
        return d * E;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            x = new int[N]; y = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            E = Double.parseDouble(br.readLine());

            boolean[] v = new boolean[N];
            double[] P = new double[N]; Arrays.fill(P, Double.MAX_VALUE);
            P[0] = 0.0;
            int cnt = 0;
            Double mst = 0.0;
            for (int i = 0; i < N; i++) {
                int minVertex = -1;
                Double min = Double.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!v[j] && min > P[j]) {
                        min = P[j];
                        minVertex = j;
                    }
                }
                v[minVertex] = true;
                mst += min;
                if (cnt++ == N - 1) break;
                for (int j = 0; j < N; j++) {
                    if (v[j]) continue;
                    Double cost = cost(x[j], y[j], x[minVertex], y[minVertex]);
                    if (P[j] > cost) P[j] = cost;
                }
            }
            System.out.println("#" + t + " " + Math.round(mst));
        }
    }
}