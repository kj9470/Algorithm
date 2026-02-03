import java.io.*;
import java.util.*;

public class Solution {
	static int farm[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(' ');
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j) - '0';
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				if (i <= N / 2) {
					for (int j = N / 2 - i; j < N / 2 + i + 1; j++) {
						result += farm[i][j];
					}
				} else {
					for (int j = i - N / 2; j < N + N / 2 - i; j++) {
						result += farm[i][j];
					}
				}
			}
			sb.append(result);
			System.out.println(sb);
		}
	}
}
