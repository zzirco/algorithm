package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_bj_2468_안전영역 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int max = Integer.MIN_VALUE;
		boolean[][] v = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max<arr[i][j]) max = arr[i][j];
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int h=0; h<=max; h++) {
			if(h==0) ans = 1;
			int cnt = 0;
			v = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]>h&&!v[i][j]) {
						ArrayDeque<int[]> q = new ArrayDeque<>();
						v[i][j] = true;
						q.offer(new int[]{i,j});
						while(!q.isEmpty()) {
							int[] ij = q.poll();
							int I = ij[0];
							int J = ij[1];
							for(int d=0; d<4; d++) {
								int ni = I + di[d];
								int nj = J + dj[d];
								if(ni>=0&&ni<N&&nj>=0&&nj<N&&arr[ni][nj]>h&&!v[ni][nj]) {
									v[ni][nj] = true;
									q.offer(new int[]{ni,nj});
								}
							}
						}
						cnt++;
					}
				}
			}
			if(ans<cnt) ans = cnt;
		}
		System.out.println(ans);
		br.close();
	}
}
