import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(' ');
			
			int [][] map = new int[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
				}
			}

			int max = -1;
			for (int i = M; i < N + 1; i++) {
				for (int j = M; j < N + 1; j++) {
					int sum = map[i][j] - map[i - M][j] - map[i][j - M] + map[i - M][j - M];
					max = Math.max(sum, max);
				}
			}
			sb.append(max);
			System.out.println(sb);
		}
	}
}
