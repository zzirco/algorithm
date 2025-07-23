package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_bj_1245_농장관리 {
	static int[] di = {-1,-1,-1,0,1,1,1,0};
	static int[] dj = {-1,0,1,1,1,0,-1,-1};
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static boolean flag;
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			for(int d=0; d<8; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M) {
					if(map[i][j]<map[ni][nj]) {
						flag = false;
					}
					if(!v[ni][nj]&&map[ni][nj]!=0&&map[i][j]==map[ni][nj]) {
						q.offer(new int[] {ni,nj});
						v[ni][nj] = true;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0&&!v[i][j]) {
					flag = true;
					bfs(i,j);
					if(flag) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
/*
8 7
4 3 2 2 1 0 1
3 3 3 2 1 0 1
2 2 2 2 1 0 0
2 1 1 1 1 0 0
1 1 6 6 0 1 0
0 0 0 1 1 1 0
0 1 2 2 5 1 0
0 1 1 1 2 1 0
*/