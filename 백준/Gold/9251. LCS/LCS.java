import java.io.*;
import java.util.*;

public class Main {
    static String A, B;
    static int MAX_N = 1000;
    static boolean[][] isCached = new boolean[MAX_N + 1][MAX_N + 1];
    static int[][] cacheValue = new int[MAX_N + 1][MAX_N + 1];

    static int dp(int i, int j) {
        if (i == A.length() || j == B.length()) return 0;
        if (!isCached[i][j]) {
            isCached[i][j] = true;
            if (A.charAt(i) == B.charAt(j)) {
                cacheValue[i][j] = dp(i + 1, j + 1) + 1;
            } else {
                cacheValue[i][j] = Math.max(dp(i + 1, j), dp(i, j + 1));
            }
        }
        return cacheValue[i][j];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        System.out.println(dp(0, 0));

    }
}