package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1182_부분수열의합 {
	static int N, S;
	static int ans;
	static int[] arr;
	static void subset(int cnt, int sum) {
		if(cnt==N) {
			if(sum==S) ans++;
			return;
		}
		subset(cnt+1,sum+arr[cnt]);
		subset(cnt+1,sum);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		ans = 0;
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		subset(0,0);
		if(S==0) ans--;
		System.out.println(ans);
	}
}
