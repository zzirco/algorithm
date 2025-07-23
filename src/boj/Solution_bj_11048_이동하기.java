package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_11048_이동하기 {
	static final int[] di = {-1,0,-1};
	static final int[] dj = {0,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][] dp = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		dp[0][0] = arr[0][0];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i==0&&j==0) continue;
				for(int d=0; d<3; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if(ni>=0&&nj>=0) {
						dp[i][j] = Math.max(dp[i][j], dp[ni][nj]);
					}
				}
				dp[i][j] += arr[i][j];
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
}
