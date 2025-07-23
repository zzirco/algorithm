package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_14501_퇴사 {
	static int N, ans;
	static int[][] arr;
	public static void subs(int cnt, int sum) {
		if(cnt>=N) {
			ans = Math.max(ans, sum);
			return ;
		}
		if(cnt+arr[cnt][0]<=N) subs(cnt+arr[cnt][0], sum+arr[cnt][1]);
		else subs(cnt+arr[cnt][0], sum);
		subs(cnt+1, sum);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = Integer.MIN_VALUE;
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		subs(0,0);
		System.out.println(ans);
	}
}
/*
3
5 10
2 10
1 10
*/
