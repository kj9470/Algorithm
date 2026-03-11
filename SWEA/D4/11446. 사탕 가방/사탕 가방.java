import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			
			long[] nums = new long[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { 
				nums[i] = Long.parseLong(st.nextToken());
			}
			
			long low = 1;
			long high = (long) Math.pow(10, 18);
			long result = 0;
			
			while (low <= high) {
				long mid = (low + high) / 2;
				if (mid == 0) break;
				
				long candyCountInABag = 0;
				for (int i = 0; i < N; i++) {
					candyCountInABag += nums[i] / mid;
				}
				
				if (candyCountInABag >= M) {
					result = mid;
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}