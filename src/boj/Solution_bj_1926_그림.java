package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_1926_그림 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static int area = 0;
	static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		int cur = 1;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<n&&nj>=0&&nj<m&&!v[ni][nj]&&map[ni][nj]==1) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
					cur++;
				}
			}
		}
		return cur;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!v[i][j]&&map[i][j]==1) {
					int cur = bfs(i,j);
					cnt++;
					area = Math.max(area, cur);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(area);
	}
}
