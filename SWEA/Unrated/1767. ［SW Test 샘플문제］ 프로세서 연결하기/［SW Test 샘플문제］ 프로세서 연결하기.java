import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static int[][] grid;
	static List<int[]> cores;
	static int maxCore, minCount;
	
	static void dfs(int depth, int coreCount, int wireCount) {
		if (depth == cores.size()) {
			if (maxCore < coreCount) {
				maxCore = coreCount;
				minCount = wireCount;
			} else if (maxCore == coreCount) {
				if (minCount > wireCount) {
					minCount = wireCount;
				}
			}
			return;
		}
		
		int[] currCore = cores.get(depth);
		
		if (currCore[0] == 0 || currCore[0] == N - 1 || 
				currCore[1] == 0 || currCore[1] == N - 1) {
			dfs(depth + 1, coreCount + 1, wireCount);
		}
		
		for (int i = 0; i < dx.length; i++) {
			int[] dir = new int[] { dx[i], dy[i] };
			int wireLength = countWireLength(currCore, dir);
			if (wireLength != -1) {
				setGrid(currCore, dir, wireLength, 2);
				dfs(depth + 1, coreCount + 1, wireCount + wireLength);
				setGrid(currCore, dir, wireLength, 0);
			}
		}
		dfs(depth + 1, coreCount, wireCount);
		
	}
	
	static int countWireLength(int[] core, int[] dir) {
		int startX = core[0], startY = core[1];
		int dirX = dir[0], dirY = dir[1];
		int nx = startX, ny = startY;
		int count = 0;
		while (true) {
			nx += dirX; ny += dirY;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				break;
			}

			if (grid[nx][ny] != 0) {
				count = -1;
				break;
			}
			
			count++;
		}
		
		return count;
	}
	static void setGrid(int[] startPoint, int[] dir, int count, int value) {
		int startX = startPoint[0], startY = startPoint[1];
		int dirX = dir[0], dirY = dir[1];
		int nx = startX, ny = startY;
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
        	minCount = Integer.MAX_VALUE;

        	
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (grid[i][j] == 1) {
						cores.add(new int[] {i, j});
					}
				}
			}
        	
        	dfs(0, 0, 0);
            System.out.println("#" + t + " " + minCount);
        }
    }
}