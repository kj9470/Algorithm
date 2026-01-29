import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            Deque<Character> deqA = new ArrayDeque<>();
            Deque<Character> deqB = new ArrayDeque<>();
            Deque<Character> result = new ArrayDeque<>();

            String A = st.nextToken();
            String B = st.nextToken();

            for(char ch: A.toCharArray()) {
                deqA.push(ch);
            }
            for(char ch: B.toCharArray()) {
                deqB.push(ch);
            }

            int carry = 0;
            while (!deqA.isEmpty() || !deqB.isEmpty() || carry != 0) {
                int a = 0, b = 0;
                if(!deqA.isEmpty()) a = deqA.pop() - '0';
                if(!deqB.isEmpty()) b = deqB.pop() - '0';

                int sum = a + b + carry;
                result.addFirst((char)((sum % 10) + '0'));
                carry = sum / 10;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            for (char ch: result) sb.append(ch);

            System.out.println(sb);
        }
    }
}
