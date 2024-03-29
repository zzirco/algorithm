package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_3055_탈출 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int N, M, ans;
	static boolean[][] v;
	static char[][] map;
	static Queue<Pair> q;
	static Queue<Pair> dq;
	static class Pair{
		int i, j, cnt;
		public Pair(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	public static void bfs() {
		int size = 0;
		while(!q.isEmpty()) {
			size = dq.size();
			for (int i=0; i<size; i++) {
				Pair p = dq.poll();
				for (int d=0; d<4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if((ni<0||ni>=N||nj<0||nj>=M)) continue;
					if(map[ni][nj]=='.'||map[ni][nj]=='S') {
						map[ni][nj] = '*';
						dq.offer(new Pair(ni,nj,p.cnt+1));
					}
				}
			}
			size = q.size();
			for (int i=0; i<size; i++) {
				Pair p = q.poll();
				for (int d=0; d<4; d++) {
					int nx = p.i + di[d];
					int ny = p.j + dj[d];
					if((nx<0||nx>=N||ny<0||ny>=M)) continue;
					if(map[nx][ny]=='D') {
						ans = p.cnt+1;
						return;
					}
					if(map[nx][ny] == '.') {
						map[nx][ny] = 'S';
						q.offer(new Pair(nx,ny,p.cnt+1));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new char[N][M];
		v = new boolean[N][M];
		q = new ArrayDeque<>();
		dq = new ArrayDeque<>();
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='*') dq.offer(new Pair(i,j,0));
				else if(map[i][j]=='S') q.offer(new Pair(i,j,0));
			}
		}
		bfs();
		String s = ans==0?"KAKTUS":""+ans;
		System.out.println(s);
		br.close();
	}
}

