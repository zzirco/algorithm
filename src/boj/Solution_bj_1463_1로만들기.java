package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_1463_1로만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[N+1];
		dp[1] = 0;
		if(N==1) {
			System.out.println(0);
			return;
		}
		if(N==2||N==3) {
			System.out.println(1);
			return;
		}
		dp[2] = 1;
		dp[3] = 1;
		for(int n=4; n<=N; n++) {
			if(n%3==0&&n%2==0) {
				dp[n] = Math.min(dp[n/3]+1,dp[n/2]+1);
			} else if(n%3==0) {
				dp[n] = Math.min(dp[n/3]+1,dp[n-1]+1);
			} else if(n%2==0) {
				dp[n] = Math.min(dp[n/2]+1,dp[n-1]+1);
			} else {
				dp[n] = dp[n-1]+1;
			}
		}
		System.out.println(dp[N]);
	}
}
