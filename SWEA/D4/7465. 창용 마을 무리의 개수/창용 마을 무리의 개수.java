import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[] parent;

    static void resetParent(int n) {
        for (int i = 0; i <= n; i++) {
            parent[i] = -1;
        }
    }

    static int find(int n) {
        if (parent[n] < 0) return n;
        return parent[n] = find(parent[n]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        if (parent[x] < parent[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (parent[x] == parent[y]) parent[x]--;
        parent[y] = x;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            resetParent(N);
            int a, b;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int count = 0;
            for (int i = 0; i <= N; i++) {
                if (parent[i] < 0) count++;
            }
            System.out.println("#" + t + " " + (count - 1));
        }
    }
}