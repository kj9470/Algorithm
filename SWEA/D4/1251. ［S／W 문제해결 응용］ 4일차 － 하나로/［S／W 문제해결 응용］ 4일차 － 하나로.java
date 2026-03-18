import java.io.*;
import java.util.*;

public class Solution {
	static long mst(long[][] islands, double E) {
		int N = islands.length;
		long[] P = new long[N];
		boolean[] v = new boolean[N];
		Arrays.fill(P, Long.MAX_VALUE);
		P[0] = 0;
		long mst = 0; int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			long min = Long.MAX_VALUE; int minVertex = -1; 
			for (int j = 0; j < N; j++) {
				if (!v[j] && min > P[j]) {
					min = P[j]; minVertex = j;
				}
			}
						
			v[minVertex] = true; mst += min;
			if (cnt++ == N - 1) { break; }
			
			for (int j = 0; j < N; j++) {
				if (!v[j] && P[j] > calcDist(islands[minVertex], islands[j])) {
					P[j] = calcDist(islands[minVertex], islands[j]);
				}
			}
		}
		return Math.round(mst * E);
	}
	
	static long calcDist(long[] a, long[] b) {
		return (long) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[][] islands = new long[N][2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i][0] = Long.parseLong(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i][1] = Long.parseLong(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			long result = mst(islands, E);
			
			System.out.println("#" + t + " " + result);
		}
	}
}