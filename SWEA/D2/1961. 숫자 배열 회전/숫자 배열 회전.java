import java.io.*;
import java.util.*;

public class Solution {
    static int[][] rotate(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] r90 = rotate(arr);
            int[][] r180 = rotate(r90);
            int[][] r270 = rotate(r180);

            System.out.println("#" + t);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(r90[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(r180[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(r270[i][j]);
                }
                System.out.println();
            }
        }
    }
}