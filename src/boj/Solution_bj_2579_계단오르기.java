package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_bj_2579_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(arr[1]);
			return;
		}
		int[][] dp = new int[N+1][3]; //현재까지 j번 연속해서 계단을 밟았을 때 최대값
		dp[1][1] = arr[1]; dp[1][2] = 0;
		dp[2][1] = arr[2]; dp[2][2] = arr[1]+arr[2];
		for(int i=3; i<=N; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
			dp[i][2] = dp[i-1][1] +arr[i];
		}
		System.out.println(Math.max(dp[N][1], dp[N][2]));
	}
}
