import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] x;
    static int[] y;
    static double E;
    static int[] parents;

    static class Edge {
        int from, to;
        double cost;

        Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static void makeSets() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }

    static boolean union(int x, int y) {
        int xRoot = findSet(x);
        int yRoot = findSet(y);
        if (xRoot == yRoot) return false;
        parents[yRoot] = xRoot;
        return true;
    }

    static double getCost(int i, int j) {
        double cx = x[i] - x[j];
        double cy = y[i] - y[j];
        double d = cx * cx + cy * cy;
        return d * E;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            x = new int[N];
            y = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            E = Double.parseDouble(br.readLine());

            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    edges.add(new Edge(i, j, getCost(i, j)));
                }
            }

            edges.sort(Comparator.comparingDouble(a -> a.cost));

            makeSets();

            double mst = 0;
            int count = 0;
            for (Edge e: edges) {
                if (union(e.from, e.to)) {
                    mst += e.cost;
                    if (count++ == N - 1) break;
                }
            }

            System.out.println("#" + t + " " + Math.round(mst));
        }
    }
}
