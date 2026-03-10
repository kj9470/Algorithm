import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static double E;
	static long[][] islands;
	
	static long calcDist(long[] a, long[] b) {
		return (long) Math.pow(a[0] - b[0], 2) + (long) Math.pow(a[1] - b[1], 2);
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            islands = new long[N][2];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
				islands[i][0] = Long.parseLong(st.nextToken());
			}
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
				islands[i][1] = Long.parseLong(st.nextToken());
			}
            
            E = Double.parseDouble(br.readLine());
        	
            boolean[] v = new boolean[N];
            long[] dist = new long[N]; Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            long mst = 0;
            int cnt = 0;
            
            for (int i = 0; i < N; i++) {
            	long min = Long.MAX_VALUE;
            	int minVertex = -1;
            	for (int j = 0; j < N; j++) {
					if(!v[j] && min > dist[j]) {
						min = dist[j]; minVertex = j;
					}
				}
            	
            	v[minVertex] = true;
            	mst += min;
            	if (cnt++ == N - 1) { break; }
            	
            	for (int j = 0; j < N; j++) {
					if (!v[j] && dist[j] > calcDist(islands[minVertex], islands[j])) {
						dist[j] = calcDist(islands[minVertex], islands[j]);
					}
				}
			}
            long result = Math.round(mst * E);
            System.out.println("#" + t + " " + result);
        }
    }
}