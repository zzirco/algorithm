package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_11726_2xn타일링 {
	static long[] dp;
	static long fibo(int n) {
		if(n>=3&&dp[n]==0) {
			dp[n] = (fibo(n-1) + fibo(n-2))%10007;
		}
		return dp[n];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		dp = new long[N+1];
		dp[0] = 0;
		dp[1] = 1;
		if(N==1) {
			System.out.println(1);
			return;
		}
		dp[2] = 2;
		System.out.println(fibo(N));
	}
}
