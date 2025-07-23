package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_12865_평범한배낭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		System.out.println(dp[K]);
		br.close();
	}
}