import java.io.*;
import java.util.*;

public class Solution {
    static int N, count;
    static boolean[] col, slash, bSlash;

    static void setQueen(int row) {
        if (row > N) {
            ++count;
            return;
        }

        for (int c = 1; c <= N; c++) {
            if (col[c] || slash[row + c] || bSlash[(row - c) + N]) continue;

            col[c] = slash[row + c] = bSlash[(row - c) + N] = true;
            setQueen(row + 1);
            col[c] = slash[row + c] = bSlash[(row - c) + N] = false;
        }
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            count = 0;

            col = new boolean[N + 1];
            slash = new boolean[2 * N + 1];
            bSlash = new boolean[2 * N + 1];

            setQueen(1);
            System.out.println("#" + tc + " " + count);
        }
    }
}
