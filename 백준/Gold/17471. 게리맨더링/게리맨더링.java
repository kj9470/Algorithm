import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] pop;
	static int[][] G;
	static boolean[] selected;
	static int minSub;
	static void perm(int idx) {
		if (idx == N + 1) {
			if (checkPossibleCase(selected)) {
				minSub = Math.min(minSub, calcSubPop(selected));
			}
			return;
		}

		selected[idx] = false;
		perm(idx + 1);
		selected[idx] = true;
		perm(idx + 1);
	}
	static int calcSubPop(boolean[] arr) {
		int teamA = 0, teamB = 0;
		
		for (int i = 1; i < N + 1; i++) {
			if (arr[i]) {
				teamA += pop[i];
			} else {
				teamB += pop[i];
			}
		}
		
		return Math.abs(teamA - teamB);
	}
	static boolean checkPossibleCase(boolean[] arr) {
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			if (arr[i]) {
				listA.add(i);
			} else {
				listB.add(i);
			}
		}
		
		if (listA.size() == 0 || listB.size() == 0) {
			return false;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] found = new boolean[N + 1];
		
		queue.offer(listA.get(0));
		found[listA.get(0)] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int[] adj = G[curr];
			for (int i = 0; i < adj.length; i++) {
				if (!found[adj[i]] && arr[adj[i]] == arr[curr]) {
					queue.offer(adj[i]);
					found[adj[i]] = true;
				}
			}
		}
		
		int countA = 0;
		for (int i = 0; i < found.length; i++) {
			if (found[i]) {
				countA++;
			}
		}
		
		queue = new ArrayDeque<>();
		found = new boolean[N + 1];
		
		queue.offer(listB.get(0));
		found[listB.get(0)] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int[] adj = G[curr];
			for (int i = 0; i < adj.length; i++) {
				if (!found[adj[i]] && arr[adj[i]] == arr[curr]) {
					queue.offer(adj[i]);
					found[adj[i]] = true;
				}
			}
		}
		
		int countB = 0;
		for (int i = 0; i < found.length; i++) {
			if (found[i]) {
				countB++;
			}
		}
		
		return countA + countB == N;
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		pop = new int[N + 1];
		selected = new boolean[N + 1];
		minSub = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		G = new int[N + 1][];
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			G[i] = new int[Integer.parseInt(st.nextToken())];
			for (int j = 0; j < G[i].length; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(1);
		
		if (minSub == Integer.MAX_VALUE) { minSub = -1; }
		
		System.out.println(minSub);
		br.close();
	}
}

