import java.io.*;
import java.util.*;

public class Solution {
	static int plusShape(int[][] arr, int x, int y, int m) {
		int result = 0;
		for (int i = x - m + 1; i < x + m; i++) {
			for (int j = y - m + 1; j < y + m; j++) {
				if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
					if (i == x) {
						result += arr[i][j];
					}
					if (j == y) {
						result += arr[i][j];
					}
				}
			}
		}
		return result - arr[x][y];
	}
	
    static int xShape(int[][] arr, int x, int y, int m, int n) {
        int result = arr[x][y]; 
        for (int i = 1; i < m; i++) {
            if (x - i >= 0 && y - i >= 0) result += arr[x - i][y - i];
        }
        for (int i = 1; i < m; i++) {
            if (x - i >= 0 && y + i < n) result += arr[x - i][y + i];
        }
        for (int i = 1; i < m; i++) {
            if (x + i < n && y - i >= 0) result += arr[x + i][y - i];
        }
        for (int i = 1; i < m; i++) {
            if (x + i < n && y + i < n) result += arr[x + i][y + i];
        }
        return result;
    }


	public static void main(String args[]) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 st = new StringTokenizer(br.readLine());
		 int T = Integer.parseInt(st.nextToken());
		 
		 for (int t = 1; t <= T; t++) {
			 st = new StringTokenizer(br.readLine());
			 int N = Integer.parseInt(st.nextToken());
			 int M = Integer.parseInt(st.nextToken());
			 
			 int[][] arr = new int[N][N];
			 for (int i = 0; i < N; i++) {
				 st = new StringTokenizer(br.readLine());
				 for (int j = 0; j < N; j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
				 }
			 }
			 
			 int maxResult = 0;
			 int result = 0;
			 for (int i = 0; i < N; i++) {
				 for (int j = 0; j < N; j++) {
					 result = Math.max(plusShape(arr, i, j, M), xShape(arr, i, j, M, N));
					 maxResult = Math.max(maxResult, result);
				 }
			 }
			 
			 System.out.print("#" + t + " ");
			 System.out.println(maxResult);
		 }
	}
}