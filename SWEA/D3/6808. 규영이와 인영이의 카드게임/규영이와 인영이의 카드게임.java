import java.io.*;
import java.util.*;

public class Solution {
	static int N = 9;
	static int win = 0;
	static int lose = 0;
	static int[] card = new int[N];
	static int[] inMatchCard = new int[N];
	static boolean[] visited = new boolean[N];
	
	static void match(int[] gyu, int[] in) {
		int gScore = 0;
		int iScore = 0;
		for (int i = 0; i < N; i++) {
			if (gyu[i] > in[i]) {
				gScore += gyu[i] + in[i];
			} else {
				iScore += gyu[i] + in[i];
			}
		}
		if (gScore > iScore) {
			win++;
		} else {
			lose++;
		}
	}
	
	static void perm(int cnt, int[] inCard) {
		if (cnt == N) {
			match(card, inMatchCard);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			inMatchCard[cnt] = inCard[i];
			perm(cnt + 1, inCard);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			win = 0;
			lose = 0;
			visited = new boolean[N];
			inMatchCard = new int[N];
			card = new int[N];
			int[] inCard = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			int index = 0;
			for (int i = 1; i <= N * 2; i++) {
				boolean found = false;
				for (int j = 0; j < N; j++) {
					if (card[j] == i) {
						found = true;
						break;
					}
				}
				if (!found) {
					inCard[index++] = i;
				}
			}
			perm(0, inCard);
			sb.append(win).append(" ").append(lose);
			System.out.println(sb);
		}
	}
}
