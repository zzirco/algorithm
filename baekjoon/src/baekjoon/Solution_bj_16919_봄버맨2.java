package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16919_봄버맨2 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int R, C, N;
	static char[][] map;
	static Queue<int[]> q = new ArrayDeque<>();
	static int ans;
	static void bfs() {
		int size = q.size();
		for(int k=0; k<size; k++) {
			int[] ij = q.poll();
			int i = ij[0];
			int j = ij[1];
			map[i][j] = '.';
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<R&&nj>=0&&nj<C) {
					map[ni][nj] = '.';
				}
			}
		}
	}
	public static void fill() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='O') q.offer(new int[] {i,j,0}); 
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = 'O';
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		if(N!=1) N = N%4+4;
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int t = 1;
		while(t<N) {
			fill();
			t++;
			if(t>=N) break;
			bfs();
			t++;
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
