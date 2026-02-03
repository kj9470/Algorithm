import java.io.*;
import java.util.*;

public class Main {
	static int N = 100;
	static int[][] map = new int[N][N];
	static int[] di = {1, 0, 0, -1};
	static int[] dj = {0, 1, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int paper = Integer.parseInt(br.readLine());
		while (paper > 0) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			for (int i = a; i < a + 10; i++) {
				for (int j = b; j < b + 10; j++) {
					map[i][j] = 1;
				}
			}
			paper--;
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int mi = i + di[d];
						int mj = j + dj[d];
						if (mi < 0 || mi >= N || mj < 0 || mj >= N) {
							result++;
						} else if (map[mi][mj] == 0) {
							result++;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
