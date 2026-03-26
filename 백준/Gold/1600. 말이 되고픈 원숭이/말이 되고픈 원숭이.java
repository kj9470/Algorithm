import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1, 1,  0, 0};
	static int[] dy = { 0, 0, -1, 1};
	static int[] hdx = {-1, -2, -2, -1,  1,  2, 2, 1};
	static int[] hdy = {-2, -1,  1,  2, -2, -1, 1, 2};
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; StringBuilder sb;
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][][] v = new boolean[N][M][K + 1];
		queue.offer(new int[] {0, 0, K, 0});
		v[0][0][K] = true;
		int result = -1;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[0] == N - 1 && curr[1] == M - 1) {
				result = curr[3]; break;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 1 && !v[nx][ny][curr[2]]) {
					queue.offer(new int[] {nx, ny, curr[2], curr[3] + 1});
					v[nx][ny][curr[2]] = true;
				}
			}
			
			if (curr[2] > 0) {
				for (int i = 0; i < hdx.length; i++) {
					int nx = curr[0] + hdx[i];
					int ny = curr[1] + hdy[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 1 && !v[nx][ny][curr[2] - 1]) {
						queue.offer(new int[] {nx, ny, curr[2] - 1, curr[3] + 1});
						v[nx][ny][curr[2] - 1] = true;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}

