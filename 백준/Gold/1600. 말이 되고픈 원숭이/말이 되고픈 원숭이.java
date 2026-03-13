import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1 ,1 };
	static int[] hdx = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] hdy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int K, W, H;
	static int[][] map;
	
	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][][] v = new boolean[H][W][K + 1];
		queue.offer(new int[] {0, 0, 0, K});
		v[0][0][K] = true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if (curr[0] == H - 1 && curr[1] == W - 1) {
				return curr[2];
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = curr[0] + dx[i], ny = curr[1] + dy[i];
				if (0 <= nx && nx < H && 0 <= ny && ny < W && !v[nx][ny][curr[3]] && map[nx][ny] != 1) {
					queue.offer(new int[] {nx, ny, curr[2] + 1, curr[3]});
					v[nx][ny][curr[3]] = true;
				}
			}
			if (curr[3] > 0) {
				for (int i = 0; i < hdx.length; i++) {
					int nx = curr[0] + hdx[i], ny = curr[1] + hdy[i];
					if (0 <= nx && nx < H && 0 <= ny && ny < W && !v[nx][ny][curr[3] - 1] && map[nx][ny] != 1) {
						queue.offer(new int[] {nx, ny, curr[2] + 1, curr[3] - 1});
						v[nx][ny][curr[3] - 1] = true;
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
		int result = bfs();
		
		System.out.println(result);
	}
}

