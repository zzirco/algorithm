package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15683_감시 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		boolean[][] v = new boolean[N][M];
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) v[i][j] = true;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]!=0&&arr[i][j]!=6) {
					v[i][j] = true;
					int I = i;
					int J = j;
					int d = 0;
					while(d<4) {
						int ni = I + di[d];
						int nj = J + dj[d];
						if(ni>=0&&ni<N&&nj>=0&&nj<M&&arr[ni][nj]!=6) {
							v[ni][nj] = true;
							I = ni;
							J = nj;
							continue;
						}
						int cnt = 0;
						for(int r=0; r<N; r++) {
							for(int c=0; c<M; c++) {
								if(!v[r][c]) cnt++;
							}
						}
						ans = Math.min(ans,cnt);
						I = i;
						J = j;
						d++;
						v = new boolean[N][M];
					}
				}
			}
		}
		System.out.println(ans);
	}
}
