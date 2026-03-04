import java.io.*;
import java.util.*;
 
public class Solution {
    static int N;
    static int[] weights;
    static int result;
    static boolean[] v;
    static int weightSum;
 
    static int factorial(int n) {
        int fn = 1;
        for (int i = 1; i <= n; i++) {
            fn *= i;
        }
        return fn;
    }
 
    static void dfs(int count, int left, int right, int sum) {
        if (left < right) {
            return;
        }
        if (left >= right + (weightSum - sum)) {
            int k = N - count;
            result += factorial(k) * Math.pow(2, k);
            return;
        }
        if (N == count) {
            if (left > right) {
                result++;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            int current = weights[i];
            dfs(count + 1, left + current, right, sum + current);
            dfs(count + 1, left, right + current, sum + current);
            v[i] = false;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            weights = new int[N];
            v = new boolean[N];
            weightSum = 0;
            result = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int w = Integer.parseInt(st.nextToken());
                weights[i] = w;
                weightSum += w;
            }
            dfs(0, 0, 0, 0);
            System.out.println("#" + t + " " + result);
        }
    }
}