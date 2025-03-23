package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Solution_bj_2193_이친수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Long[] dp = new Long[N+1];
		if(N==1) {
			System.out.println(1);
			return;
		}
		dp[1] = 1L;
		dp[2] = 1L;
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}
}
