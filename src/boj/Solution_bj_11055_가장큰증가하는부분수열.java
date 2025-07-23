package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_11055_가장큰증가하는부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		int max = arr[0];
		for(int i=1; i<N; i++) {
			dp[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]) dp[i] = Math.max(dp[j] + arr[i], dp[i]);
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
