import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
            Deque<String> first = new ArrayDeque<>();
            Deque<String> second = new ArrayDeque<>();
            
            int mid = (N + 1) / 2;

            for (int i = 0; i < mid; i++) first.addLast(st.nextToken());
            for (int i = 0; i < N - mid; i++) second.addLast(st.nextToken());
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            
            while (!first.isEmpty() || !second.isEmpty()) {
            	if(!first.isEmpty()) sb.append(first.pollFirst()).append(" ");
            	if(!second.isEmpty()) sb.append(second.pollFirst()).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
	}
}
