import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N;
	static int[][] grid;
	static List<int[]> cores;
	static int maxCore;
	static int minWire;
	
	static void dfs(int idx, int coreCount, int wire) {
		if (idx == cores.size()) {
			if (maxCore < coreCount) {
				maxCore = coreCount;
				minWire = wire;
			} else if (maxCore == coreCount) {
				minWire = Math.min(minWire, wire);
			}
			return;
		}
		int[] currCore = cores.get(idx);
		
		if (currCore[0] == 0 || currCore[0] == N - 1 ||
				currCore[1] == 0 || currCore[1] == N - 1) {
			dfs(idx + 1, coreCount + 1, wire);
		}
		
		for (int i = 0; i < dx.length; i++) {
			int currWireLength = checkWireLength(currCore[0], currCore[1], dx[i], dy[i]);
			if (currWireLength == - 1) continue;
			fill(currCore[0], currCore[1], dx[i], dy[i], currWireLength, 2);
			dfs(idx + 1, coreCount + 1, wire + currWireLength);
			fill(currCore[0], currCore[1], dx[i], dy[i], currWireLength, 0);
		}
		dfs(idx + 1, coreCount, wire);
	}
	
	static int checkWireLength(int x, int y, int dirX, int dirY) {
		int nx = x, ny = y;
		int wireLength = 0;
		while (true) {
			nx += dirX; ny += dirY;
			if (0 > nx || nx >= N || 0 > ny || ny >= N) {
				break;
			}
			if (grid[nx][ny] != 0) {
				wireLength = -1;
				break;
			}
			wireLength++;
		}
		return wireLength;
	}
	
	static void fill(int x, int y, int dirX, int dirY, int count, int value) {
		int nx = x, ny = y;
		for (int i = 0; i < count; i++) {
			nx += dirX; ny += dirY;
			grid[nx][ny] = value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			cores = new ArrayList<>();
			maxCore = Integer.MIN_VALUE;
			minWire = Integer.MAX_VALUE;
			
			for (int i = 0; i < grid.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < grid.length; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (grid[i][j] == 1) { cores.add(new int[] {i, j}); }
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + minWire);
		}
	}
}