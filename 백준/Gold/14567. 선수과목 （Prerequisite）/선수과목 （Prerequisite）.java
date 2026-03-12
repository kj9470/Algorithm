import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] G = new List[N + 1];
		for (int i = 0; i < G.length; i++) {
			G[i] = new ArrayList<>();
		}
		
		int[] degree = new int[N + 1];
		int[] results = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			G[a].add(b);
			degree[b]++;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				results[i] = 1;
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for (int a: G[curr]) {
				degree[a]--;
				
				if (degree[a] == 0) {
					results[a] = results[curr] + 1;
					queue.offer(a);
				}
			}
		}

		sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(results[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}

