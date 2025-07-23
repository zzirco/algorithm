package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_4963_섬의개수 {
	static int[] di = {-1,-1,-1,0,1,1,1,0};
	static int[] dj = {-1,0,1,1,1,0,-1,-1};
	static int N, M;
	static int[][] arr;
	static boolean[][] v;
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<8; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]&&arr[ni][nj]==1) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N==0&&M==0) break;
			arr = new int[N][M];
			v = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]==1&&!v[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}
