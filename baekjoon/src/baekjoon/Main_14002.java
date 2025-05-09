package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14002 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		int lis = 1;
		dp[0] = 1;
		for(int i=1; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					lis = Math.max(lis, dp[i]);
				}
			}
		}
		System.out.println(lis);
		int idx = N - 1;
		ArrayList<Integer> ans = new ArrayList<>();
		while(idx!=-1) {
			if(lis==dp[idx]) {
				ans.add(arr[idx]);
				lis--;
			}
			idx--;
		}
		for(int i=ans.size()-1; i>=0; i--) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
