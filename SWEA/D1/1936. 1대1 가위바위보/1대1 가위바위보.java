import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if (A > B) {
			if (A == 3 && B == 1) {
				System.out.println('B');
			} else {
				System.out.println('A');
			}
		} else {
			if (A == 1 && B == 3) {
				System.out.println('A');
			} else {
				System.out.println('B');
			}
		}
	}
}
