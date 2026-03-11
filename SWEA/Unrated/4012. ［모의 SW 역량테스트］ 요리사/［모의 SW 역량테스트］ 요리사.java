import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] S;
	static boolean[] v;
	static int minDiff;
	
 	static void dfs(int depth, int start) {
		if (depth == N / 2) {
			int diff = calcDiff(v);
			minDiff = Math.min(minDiff, diff);
			return;
		}
		
		for (int i = start; i <= N; i++) {
			v[i] = true;
			dfs(depth + 1, i + 1);
			v[i] = false;
		}
	}
 	
 	static int calcDiff(boolean[] arr) {
 		int sumA = 0, sumB = 0;
 		for (int i = 1; i < arr.length; i++) {
 	 		for (int j = 1; j < arr.length; j++) {
 	 			if (arr[i] && arr[j]) { sumA += S[i][j]; }
 	 			else if (!arr[i] && !arr[j]) { sumB += S[i][j]; }
 	 		}
		}
 		return Math.abs(sumA - sumB);
 	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N + 1][N + 1];
			v = new boolean[N + 1];
			minDiff = Integer.MAX_VALUE;
			
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 1);
			
			System.out.println("#" + t + " " + minDiff);
		}
	}
}