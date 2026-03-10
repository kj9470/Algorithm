import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, K;
    static Microbe[] microbes;
    static int[][] map;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int[] reverseD = {0, 2, 1, 4, 3};

    static class Microbe {
        int x;
        int y;
        int n;
        int d;
        int max;

        Microbe (int x, int y, int n, int d) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.d = d;
            this.max = n;
        }
    }

    static int[][] setMicrobes() {
        int[][] newMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    int idx = map[i][j];
                    Microbe m = microbes[idx];
                    m.x += dx[m.d];
                    m.y += dy[m.d];
                    if (isMedicine(m.x, m.y)) { // 약품 칠해진 셀 도착
                        m.n /= 2;
                        m.d = reverseD[m.d];
                    }
                    if (m.n == 0) continue;
                    m.max = m.n;
                    if (newMap[m.x][m.y] == 0) {
                        newMap[m.x][m.y] = idx;
                        microbes[idx] = m;
                    } else {
                        int newIdx = newMap[m.x][m.y];
                        Microbe newM = microbes[newIdx];
                        if (newM.max < m.max) {
                            newM.max = m.max;
                            newM.d = m.d;
                        }
                        newM.n += m.n;
                        microbes[newIdx] = newM;
                    }
                }
            }
        }
        return newMap;
    }

    static boolean isMedicine(int x, int y) {
        if (x <= 0 || x >= N - 1 || y <= 0 || y >= N - 1) return true;
        return false;
    }

    static int sumM() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    sum += microbes[map[i][j]].n;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            microbes = new Microbe[K + 1];
            int x, y, n, d;
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                microbes[i] = new Microbe(x, y, n, d);
                map[x][y] = i;
            }

            for (int i = 0; i < M; i++) {
                map = setMicrobes();
            }
            int result = sumM();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (map[i][j] > 0) {
//                        System.out.print(microbes[map[i][j]].n + " ");
//                    } else {
//                        System.out.print(map[i][j] + " ");
//                    }
//                }
//                System.out.println();
//            }
            System.out.println("#" + t + " " + result);
        }
    }
}