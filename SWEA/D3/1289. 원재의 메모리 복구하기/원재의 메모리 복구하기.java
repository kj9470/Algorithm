import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            System.out.print("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            String bit = st.nextToken();
            char current = '0';
            int count = 0;

            for (int i = 0; i < bit.length(); i++) {
                if (bit.charAt(i) != current) {
                    count += 1;
                    current = bit.charAt(i);
                }
            }
            System.out.println(count);
        }
    }
}