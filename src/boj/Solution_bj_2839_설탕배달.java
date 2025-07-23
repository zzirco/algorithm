package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_bj_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[5001];
		for(int i=0; i<=N; i++) {
			dp[i] = 5001;
		}
		dp[3] = dp[5] = 1;
		for(int i=6; i<=N; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5])+1;
		}
		if(dp[N]>=5001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}
}
