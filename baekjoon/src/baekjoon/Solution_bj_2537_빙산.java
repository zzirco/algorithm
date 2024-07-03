package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2537_빙산 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, M;
	static int[][] map;
	static int[][] tmp;
	static boolean[][] v;
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]&&map[ni][nj]!=0) {
					q.offer(new int[] {ni,nj});
					v[ni][nj] = true;
				}
			}
		}
	}
	static void bfs2(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]) {
					if(map[ni][nj]!=0) {
						tmp[ni][nj]++;
					} else {
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
		tmp = new int[N][M];
		v = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 1;
		while(true) {
			v = new boolean[N][M];
			tmp = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0&&!v[i][j]) {
						bfs2(i,j);
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] -= tmp[i][j];
					if(map[i][j]<0) map[i][j] = 0;
				}
			}
			int cnt = 0;
			v = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]!=0&&!v[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			if(cnt>=2) {
				System.out.println(year);
				break;
			}
			if(cnt==0) {
				System.out.println(0);
				break;
			}
			year++;
		}
	}
}
