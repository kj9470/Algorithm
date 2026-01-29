import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
	
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(A.add(B));
			System.out.println(sb);
		}	
	}
}
