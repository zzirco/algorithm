package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_2206_벽부수고이동하기 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int N, M;
	static int[][] arr;
	static boolean[][][] v;
	static int ans;
	static int bfs(int i, int j, int cnt, int wallCnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt,wallCnt});
		v[i][j][wallCnt] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			wallCnt = ij[3];
			if(i==N-1&&j==M-1) {
				ans = cnt;
				return ans;
			}
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M) {
					if(arr[ni][nj]==1&&!v[ni][nj][wallCnt]&&wallCnt==0) {
						v[ni][nj][1] = true;
						q.offer(new int[] {ni,nj,cnt+1,wallCnt+1});
					}
					if(arr[ni][nj]==0&&!v[ni][nj][wallCnt]) {
						v[ni][nj][wallCnt] = true;
						q.offer(new int[] {ni,nj,cnt+1,wallCnt});
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String[] sa = br.readLine().split("");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(sa[j]);
			}
		}
		System.out.println(bfs(0,0,1,0));
	}
}
