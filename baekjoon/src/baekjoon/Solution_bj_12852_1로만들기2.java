package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Solution_bj_12852_1로만들기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] p = new int[N+1];
		dp[1] = 0;
		p[1] = 0;
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			p[i] = i-1;
			if(i%2==0&&dp[i]>dp[i/2] + 1) {
				dp[i] = dp[i/2] + 1;
				p[i] = i/2;
			}
			if(i%3==0&&dp[i]>dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
				p[i] = i/3;
			}
		}
		System.out.println(dp[N]);
		int idx = N;
		while(true) {
			System.out.print(idx+" ");
			if(idx==1) {
				break;
			}
			idx = p[idx];
		}
	}
}
