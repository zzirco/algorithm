package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_bj_1003_피보나치함수 {
	static int[][] dp;
	static int[] fibonacci(int n) {
		if(dp[n][0]==-1||dp[n][1]==-1) {
			dp[n][0] = fibonacci(n-1)[0]+fibonacci(n-2)[0];
			dp[n][1] = fibonacci(n-1)[1]+fibonacci(n-2)[1];
		}
		return new int[] {dp[n][0], dp[n][1]};
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			dp = new int[41][2];
			for(int i=0; i<41; i++) {
				Arrays.fill(dp[i], -1);
			}
			dp[0][0] = 1;
			dp[0][1] = 0;
			dp[1][0] = 0;
			dp[1][1] = 1;
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0]+" "+dp[N][1]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
