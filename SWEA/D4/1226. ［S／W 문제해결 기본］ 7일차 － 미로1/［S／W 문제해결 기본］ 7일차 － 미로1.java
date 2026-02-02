import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
    static int N = 16;
	static int[][] map = new int[N][N];
	static boolean[][] v = new boolean[N][N];
    static boolean result = false;
	
	public static boolean bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			i = xy[0];
			j = xy[1];
			for (int d = 0; d < 4; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
					if (map[nx][ny] == 3) {
						return true;
					}
					if (map[nx][ny] == 0) {
						v[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	
	    int T = 10;
	    for (int t = 1; t <= T; t++) {
	    	String a = br.readLine();
	    	
		    for (int i = 0; i < N; i++) {
			    String str = br.readLine();
			    for (int j = 0; j < N; j++) {
			    	map[i][j] = str.charAt(j) - '0'; //Integer.parseInt(st.nextToken());
			    }
		    }
		    
		    result = false;
		    v = new boolean[N][N];
		    int i = 1;
		    int j = 1;
		    result = bfs(i, j);
		    
		    if (result) {
		    	System.out.println("#" + t + " " + 1);
		    } else {
		    	System.out.println("#" + t + " " + 0);
		    }
	    }
	}
}
