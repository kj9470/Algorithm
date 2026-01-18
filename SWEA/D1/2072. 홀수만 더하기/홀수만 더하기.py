import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = 10;
        for (int t = 1; t <= T; t++) {
            System.out.print("#" + t + " ");
            int result = 0;
            int number;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                if (st.hasMoreTokens()) {
                    number = Integer.parseInt((st.nextToken()));
                    if (number % 2 == 1) {
                        result += number;
                    }
                }
            }
            System.out.println(result);
        }
    }
}