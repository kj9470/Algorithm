import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] mountains;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            mountains = new int[N];
            result = 0;
            boolean up = false;
            boolean isMountain = false;
            int upMountain = 0;

            for (int i = 0; i < N; i++) {
                mountains[i] = sc.nextInt();
            }

            int recent = mountains[0];
            for (int i = 1; i < N; i++) {
                if (recent < mountains[i]) {
                    if (!up) {
                        upMountain = 1;
                    } else {
                        upMountain++;
                    }
                    isMountain = false;
                    up = true;
                } else if (recent > mountains[i]) {
                    if (up) {
                        // 올라가고 있었는데 내려감
                        result += upMountain;
                        up = false;
                        isMountain = true;
                    } else {
                        // 내려가고 있었는데 내려감
                        if (isMountain) {
                            result += upMountain;
                        }
                    }
                }
                recent = mountains[i];
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
