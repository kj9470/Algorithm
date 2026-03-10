import java.io.*;
import java.util.*;

public class Solution {
    static int V, E;
    static int[] parents;

    static void makeSets() {
        for (int i = 1; i <= V; i++) {
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V + 1];
            List<int[]> G = new ArrayList<>();
            int A, B, C;

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                G.add(new int[]{A, B, C});
            }

            G.sort(Comparator.comparingInt(a -> a[2]));
            makeSets();

            long count = 0, result = 0;
            for (int[] e: G) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if (union(u, v)) {
                    result += w;
                    count++;
                    if (count == V - 1) break;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}