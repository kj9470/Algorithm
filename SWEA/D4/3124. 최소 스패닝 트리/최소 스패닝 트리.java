import java.io.*;
import java.util.*;

public class Solution {
    static int V, E;
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            List<Edge>[] graph = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            int A, B, C;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());

                graph[A].add(new Edge(B, C));
                graph[B].add(new Edge(A, C));
            }

            boolean[] v = new boolean[V + 1];
            PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

            long result = 0;
            int count = 0;

            pq.offer(new Edge(1, 0));

            while (!pq.isEmpty() && count < V) {
                Edge cur = pq.poll();
                if (v[cur.to]) continue;

                v[cur.to] = true;
                result += cur.cost;
                count++;

                for (Edge next: graph[cur.to]) {
                    if(!v[next.to]) {
                        pq.offer(new Edge(next.to, next.cost));
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}