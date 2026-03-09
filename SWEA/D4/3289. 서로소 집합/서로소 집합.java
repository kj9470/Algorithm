import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return false;
        parent[yRoot] = xRoot;
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
            int n, a, b;
            parent = new int[N + 1];
            for (int i = 0; i < N + 1; i++) {
                parent[i] = i;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if (n == 0) { // 합집합
                    union(a, b);
                } else { // 집합 포함 확인
                    if (find(a) == find(b)) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
            }

            System.out.println("#" + t + " " + sb);
        }
    }
}