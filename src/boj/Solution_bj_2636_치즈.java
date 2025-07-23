package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_2636_치즈 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M;
	static int[][] arr;
	static boolean[][] v;
	static int cheeseCnt;
	static int ans;
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]) {
					if(arr[ni][nj]==0) {
						v[ni][nj] = true;
						q.offer(new int[] {ni,nj});
					} else {
						v[ni][nj] = true;
					}
				}
			}
		}
	}
	static boolean isDone() {
		cheeseCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) {
					cheeseCnt++;
				}
			}
		}
		if(cheeseCnt>0) {
			ans = cheeseCnt;
			return false;
		}
		else return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(!isDone()) {
			v = new boolean[N][M];
			bfs(0,0);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(v[i][j]) arr[i][j] = 0;
				}
			}
			cnt++;
		}
		System.out.println(cnt+"\n"+ans);
	}
}
