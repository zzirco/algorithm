package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2206_벽부수고이동하기 {
	static final int[] di = {0,0,-1,1};
	static final int[] dj = {-1,1,0,0};
	static int N, M;
	static int[][] arr;
	static boolean[][] v;
	static int ans;
	static int wallCnt;
	static int bfs(int i, int j, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]) {
					if(ni==N-1&&nj==M-1) {
						ans = cnt + 1;
						return ans;
					}
					if(arr[ni][nj]==1) {
						if(wallCnt==1) {
							wallCnt--;
							arr[ni][nj] = 0;
						} else {
							continue;
						}
					}
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,cnt+1});
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		ans = -1;
		wallCnt = 1;
		for(int i=0; i<N; i++) {
			String[] sa = br.readLine().split("");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(sa[j]);
			}
		}
		System.out.println(bfs(0,0,1));
	}
}
