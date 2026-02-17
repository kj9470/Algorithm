import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static List<Integer>[] graph;
    static List<Integer>[] reverseGraph;
    static boolean[] visited;

    static int bfs(List<Integer>[] g, int n) {
        visited = new boolean[N + 1];
        int count = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()) {
            int c = q.poll();
                for (int next: g[c]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                        count++;
                    }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            int u, v;
            graph = new ArrayList[N + 1];
            reverseGraph = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                reverseGraph[i] = new ArrayList<>();
            }
            visited = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                reverseGraph[v].add(u);
            }

            int result = 0, cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt = bfs(graph, i) + bfs(reverseGraph, i);
                if (cnt + 1 == N) result++;
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
