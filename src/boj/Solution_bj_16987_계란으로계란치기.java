package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_16987_계란으로계란치기 {
	static int N;
	static int[][] egg;
	static int max = Integer.MIN_VALUE;
	public static void sol(int idx, int cnt) {
		if(idx==N) {
			max = Math.max(max, cnt);
			return;
		}
		if(egg[idx][0]<=0||cnt==N-1) {
			sol(idx+1,cnt);
			return;
		}
		int curCnt = cnt;
		for(int i=0; i<N; i++) {
			if(i==idx) continue;
			if(egg[i][0]<=0) continue;
			hit(idx,i);
			if(egg[i][0]<=0) cnt++;
			if(egg[idx][0]<=0) cnt++;
			sol(idx+1,cnt);
			recover(idx,i);
			cnt = curCnt;
		}
	}
	public static void hit(int cur, int target) {
		egg[cur][0] -= egg[target][1];
		egg[target][0] -= egg[cur][1];
	}
	public static void recover(int cur, int target) {
		egg[cur][0] += egg[target][1];
		egg[target][0] += egg[cur][1];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		egg = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		sol(0,0);
		System.out.println(max);
	}
}
