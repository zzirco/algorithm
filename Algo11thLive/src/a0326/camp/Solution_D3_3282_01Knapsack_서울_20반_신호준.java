package a0326.camp;

import java.io.*;
import java.util.*;

public class Solution_D3_3282_01Knapsack_서울_20반_신호준 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3282.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] items = new int[N+1][2];
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				items[i][0] = Integer.parseInt(st.nextToken());
				items[i][1] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[K+1];
			for (int i=1; i<=N; i++) {
				for (int j=K; j>=items[i][0]; j--) {
					dp[j] = Math.max(dp[j], dp[j-items[i][0]] + items[i][1]);
				}
			}
			sb.append("#"+tc+" "+dp[K]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
