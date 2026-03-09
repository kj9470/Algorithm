import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;
	static int[][] G;
	
	static boolean[][] visitedIsland;
	static boolean[] visitedNode;
	
	static void bfs(int x, int y, int count) {
		Queue<int[]> queue = new ArrayDeque<>();
		map[x][y] = count;
		visitedIsland[x][y] = true;
		queue.offer(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cx = curr[0], cy =curr[1];
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (0<=nx && nx<N && 0<=ny && ny<M 
						&& map[nx][ny] == 1 && !visitedIsland[nx][ny]) {
					map[nx][ny] = count;
					visitedIsland[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	static void searchShortestBridge(int x, int y, int count) {
		for (int i = 0; i < 4; i++) {
			int nx = x; int ny = y;
			int bridgeLength = 0;
			int connectedIsland = -1;
			while(true) {
				nx += dx[i]; ny += dy[i];
				if (0<=nx && nx<N && 0<=ny && ny<M) {
					if (map[nx][ny] == count) { break; }
					if (map[nx][ny] != 0) {
						connectedIsland = map[nx][ny];
						break;
					}
					bridgeLength++;
				} else break;
			}
			if (bridgeLength >= 2 && connectedIsland != -1) {
				int minValue = Math.min(G[count][connectedIsland], bridgeLength);
				G[count][connectedIsland] = minValue;
				G[connectedIsland][count] = minValue;
				continue; 
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visitedIsland = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int islandCount = 2; // 섬 개수: islandCount - 1
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, islandCount++);
				}
			}
		}
		
		G = new int[islandCount + 1][islandCount + 1];
		for (int[] g: G) { Arrays.fill(g, 20); }
		visitedNode = new boolean[islandCount + 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= 2) {
					searchShortestBridge(i, j, map[i][j]);
				}
			}
		}
		
		int[] P = new int[islandCount + 1]; 
		Arrays.fill(P, Integer.MAX_VALUE);
		P[2] = 0;
		int mst = 0, cnt = 0;
		
		for (int i = 2; i < islandCount; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 2; j < islandCount; j++) {
				if (!visitedNode[j] && min > P[j]) {
					min = P[j]; minVertex = j;
				}
			}
			
			if (minVertex == -1) { mst = -1; break; }
			
			visitedNode[minVertex] = true;
			mst += min;
			if (cnt++ == islandCount - 2) { break; }
			for (int k = 2; k < islandCount; k++) {
				if (!visitedNode[k] && G[minVertex][k] != 20 
						&& P[k] > G[minVertex][k]) {
					P[k] = G[minVertex][k];
				}
			}
		}
		System.out.println(mst);
	}
}

