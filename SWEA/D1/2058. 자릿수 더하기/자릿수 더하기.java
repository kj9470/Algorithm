import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int result = 0;
		
		while (num > 0) {
			result += num % 10;
			num /= 10;
		}
		
		System.out.println(result);
	}
}
